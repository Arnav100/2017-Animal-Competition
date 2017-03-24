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
  public static DigitalInput toggleSwitch;

  // static values
  public static HashMap<String, Double> values = new HashMap<String, Double>();

  public static void init() {

    // static values: 0.0 to 1.0, no negatives!
    values.put("open_gadget", 1.0);
    values.put("close_gadget", 0.16);
    values.put("climber", 1.0);

    // initial static values with (+/-) control
    values.put("agitate", 0.87);
    values.put("loader", 0.86);
    values.put("shooter", 0.84);
    values.put("intake_in", 0.90);
    values.put("intake_out", 0.90);
    values.put("clear_fuel", 0.75);

    // instantiate the motor controllers
    dtRSlave1 = new CANTalon(21);
    dtLSlave1 = new CANTalon(22);
    dtRSlave2 = new CANTalon(23);
    dtLSlave2 = new CANTalon(24);
    dtRMaster = new CANTalon(25);
    dtLMaster = new CANTalon(26);
    intake = new CANTalon(27);
    climber = new CANTalon(29);
    shooter = new CANTalon(31);
    gadgetL = new CANTalon(32);
    loader = new CANTalon(33);
    gadgetR = new CANTalon(34);

    // right side slave setup
    dtRSlave1.changeControlMode(TalonControlMode.Follower);
    dtRSlave1.set(dtRMaster.getDeviceID());
    dtRSlave1.reverseOutput(true);
    dtRSlave2.changeControlMode(TalonControlMode.Follower);
    dtRSlave2.set(dtRMaster.getDeviceID());
    dtRSlave2.reverseOutput(true);

    // left side slave setup
    dtLSlave1.changeControlMode(TalonControlMode.Follower);
    dtLSlave1.set(dtLMaster.getDeviceID());
    dtLSlave1.reverseOutput(true);
    dtLSlave2.changeControlMode(TalonControlMode.Follower);
    dtLSlave2.set(dtLMaster.getDeviceID());
    dtLSlave2.reverseOutput(true);

    // master motors setup
    dtMasterMotors = new RobotDrive(dtLMaster, dtRMaster);

    // setup drive train encoders
    dtRMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);
    dtLMaster.setFeedbackDevice(FeedbackDevice.QuadEncoder);

    // instantiate pneumatic system
    compressor = new Compressor(50); // device id
    solenoid = new Solenoid(50, 5); // device id, channel

    // disable saftey settings on replay code motors
    dtMasterMotors.setSafetyEnabled(false);
    intake.setSafetyEnabled(false);
    loader.setSafetyEnabled(false);
    shooter.setSafetyEnabled(false);
    gadgetL.setSafetyEnabled(false);
    gadgetR.setSafetyEnabled(false);

    // instantiate sensors
    dial = new AnalogPotentiometer(0, 300, 0); // channel, range, offset
    gyro = new ADXRS450_Gyro();
    toggleSwitch = new DigitalInput(9);
  }
}
