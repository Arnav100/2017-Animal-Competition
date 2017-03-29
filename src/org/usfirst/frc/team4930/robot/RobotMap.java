package org.usfirst.frc.team4930.robot;

import java.util.HashMap;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;

public class RobotMap
{
  // drive train motor controllers
  public static RobotDrive dtMasterMotors;
  public static CANTalon dtLMaster;
  public static CANTalon dtLSlave1;
  public static CANTalon dtLSlave2;
  public static CANTalon dtRMaster;
  public static CANTalon dtRSlave1;
  public static CANTalon dtRSlave2;

  // subsystem motor controllers
  public static CANTalon climber;
  public static CANTalon gadgetL;
  public static CANTalon gadgetR;
  public static CANTalon intake;
  public static CANTalon loader;
  public static CANTalon shooter;

  // pneumatic system
  public static Compressor compressor;
  public static Solenoid solenoid;

  // robot sensors
  public static AnalogPotentiometer dial;
  public static ADXRS450_Gyro gyro;
  public static DigitalInput replayToggleSwitch;
  public static DigitalInput allianceToggleSwitch;

  // static values
  public static HashMap<String, Double> values = new HashMap<String, Double>();

  public static void init() {

    // static values: 0.0 to 1.0, no negatives!
    RobotMap.values.put("open_gadget", 1.0);
    RobotMap.values.put("close_gadget", 0.10);
    RobotMap.values.put("climber", 1.0);

    // initial static values with (+/-) control
    RobotMap.values.put("agitate", 0.87);
    RobotMap.values.put("loader", 0.86);
    RobotMap.values.put("shooter", 0.84);
    RobotMap.values.put("intake_in", 0.90);
    RobotMap.values.put("intake_out", 0.90);
    RobotMap.values.put("clear_fuel", 0.75);

    // instantiate the motor controllers
    RobotMap.dtRSlave1 = new CANTalon(21);
    RobotMap.dtLSlave1 = new CANTalon(22);
    RobotMap.dtRSlave2 = new CANTalon(23);
    RobotMap.dtLSlave2 = new CANTalon(24);
    RobotMap.dtRMaster = new CANTalon(25);
    RobotMap.dtLMaster = new CANTalon(26);
    RobotMap.intake = new CANTalon(27);
    RobotMap.climber = new CANTalon(29);
    RobotMap.shooter = new CANTalon(31);
    RobotMap.gadgetL = new CANTalon(32);
    RobotMap.loader = new CANTalon(33);
    RobotMap.gadgetR = new CANTalon(34);

    // right side slave setup
    RobotMap.dtRSlave1.changeControlMode(TalonControlMode.Follower);
    RobotMap.dtRSlave1.set(RobotMap.dtRMaster.getDeviceID());
    RobotMap.dtRSlave1.reverseOutput(true);
    RobotMap.dtRSlave2.changeControlMode(TalonControlMode.Follower);
    RobotMap.dtRSlave2.set(RobotMap.dtRMaster.getDeviceID());
    RobotMap.dtRSlave2.reverseOutput(true);

    // left side slave setup
    RobotMap.dtLSlave1.changeControlMode(TalonControlMode.Follower);
    RobotMap.dtLSlave1.set(RobotMap.dtLMaster.getDeviceID());
    RobotMap.dtLSlave1.reverseOutput(true);
    RobotMap.dtLSlave2.changeControlMode(TalonControlMode.Follower);
    RobotMap.dtLSlave2.set(RobotMap.dtLMaster.getDeviceID());
    RobotMap.dtLSlave2.reverseOutput(true);

    // master motors setup
    RobotMap.dtMasterMotors = new RobotDrive(RobotMap.dtLMaster, RobotMap.dtRMaster);

    // setup drive train encoders
    RobotMap.dtRMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    RobotMap.dtLMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);

    // RobotMap.dtRMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    // RobotMap.dtLMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    // RobotMap.dtLMaster.changeControlMode(CANTalon.TalonControlMode.Position);
    // RobotMap.dtRMaster.changeControlMode(CANTalon.TalonControlMode.Position);
    RobotMap.dtRMaster.reverseSensor(true);
    //
    // RobotMap.dtRMaster.setPID(0.5, 0.001, 0.0); // Set the PID constants (p, i, d)
    // RobotMap.dtRMaster.enableControl(); // Enable PID control on the talon
    // RobotMap.dtLMaster.setPID(0.5, 0.001, 0.0); // Set the PID constants (p, i, d)
    // RobotMap.dtLMaster.enableControl(); // Enable PID control on the talon

    // instantiate pneumatic system
    RobotMap.compressor = new Compressor(50); // device id
    RobotMap.solenoid = new Solenoid(50, 5); // device id, channel

    // disable saftey settings on replay code motors
    RobotMap.dtMasterMotors.setSafetyEnabled(false);
    RobotMap.intake.setSafetyEnabled(false);
    RobotMap.loader.setSafetyEnabled(false);
    RobotMap.shooter.setSafetyEnabled(false);
    RobotMap.gadgetL.setSafetyEnabled(false);
    RobotMap.gadgetR.setSafetyEnabled(false);

    // instantiate sensors
    RobotMap.dial = new AnalogPotentiometer(0, 300, 0); // channel, range, offset
    RobotMap.gyro = new ADXRS450_Gyro(); // ribbon gyro
    RobotMap.replayToggleSwitch = new DigitalInput(8); // DIO
    RobotMap.allianceToggleSwitch = new DigitalInput(9); // DIO
  }

  public static void disableAllTalons() {
    // stop all Talons SRXs
    RobotMap.dtRMaster.set(0.0);
    RobotMap.dtLMaster.set(0.0);
    RobotMap.intake.set(0.0);
    RobotMap.climber.set(0.0);
    RobotMap.shooter.set(0.0);
    RobotMap.gadgetL.set(0.0);
    RobotMap.gadgetR.set(0.0);
    RobotMap.loader.set(0.0);
  }
}
