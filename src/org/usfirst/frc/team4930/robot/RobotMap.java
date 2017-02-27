package org.usfirst.frc.team4930.robot;

import java.util.HashMap;
import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.*;

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

  // static values
  public static HashMap<String, Double> values = new HashMap<String, Double>();

  public static void init() {

    // motor controller percentages: 0.0 to 1.0, no negatives!
    values.put("agitate", 0.45);
    values.put("loader", 0.85);
    values.put("shooter", 0.91);
    values.put("clear_loader", 0.75);
    values.put("clear_shooter", 0.75);
    values.put("open_gadget", 1.0);
    values.put("close_gadget", 0.11);
    values.put("intake_in", 1.0);
    values.put("intake_out", 0.9);
    values.put("climber", 1.0);

    if (Robot.name == "Animal") {
      initAnimal();
    } else {
      initLamina();
    }

  }

  // Animal: Competition Robot
  public static void initAnimal() {

    // instantiate the motor controllers
    dtRSlave2 = new CANTalon(21); // reversed
    dtLMaster = new CANTalon(22);
    dtRSlave1 = new CANTalon(23); // reversed
    dtLSlave1 = new CANTalon(24); // reversed
    dtRMaster = new CANTalon(25);
    dtLSlave2 = new CANTalon(26);
    intake = new CANTalon(27); // reversed
    climber = new CANTalon(29); // reversed
    shooter = new CANTalon(31);
    gadgetL = new CANTalon(32);
    loader = new CANTalon(33); // reversed
    gadgetR = new CANTalon(34);

    // instantiate pneumatic system
    compressor = new Compressor(50); // device id
    solenoid = new Solenoid(50, 5); // device id, channel

    // instantiate sensors
    dial = new AnalogPotentiometer(2, 300, 0); // channel, range, offset

    // right side slave setup
    dtRSlave1.changeControlMode(TalonControlMode.Follower);
    dtRSlave1.set(dtRMaster.getDeviceID());
    dtRSlave2.changeControlMode(TalonControlMode.Follower);
    dtRSlave2.set(dtRMaster.getDeviceID());

    // left side slave setup
    dtLSlave1.changeControlMode(TalonControlMode.Follower);
    dtLSlave1.set(dtLMaster.getDeviceID());
    dtLSlave2.changeControlMode(TalonControlMode.Follower);
    dtLSlave2.set(dtLMaster.getDeviceID());

    // reverse polarity as required
    dtRSlave1.reverseOutput(true);
    dtRSlave2.reverseOutput(true);
    dtLSlave1.reverseOutput(true);
    climber.reverseOutput(true);
    intake.reverseOutput(true);
    loader.reverseOutput(true);

    // master motors setup
    dtMasterMotors = new RobotDrive(dtLMaster, dtRMaster);
    dtMasterMotors.setSafetyEnabled(true);
    dtMasterMotors.setExpiration(0.2);
    dtMasterMotors.setSensitivity(0.5);
    dtMasterMotors.setMaxOutput(1.0);
    values.put("low_governor", 0.85);
    values.put("high_governor", 1.0);

  }

  // Lamina: Practice Robot
  public static void initLamina() {

    // instantiate the motor controllers
    dtRSlave2 = new CANTalon(21); // reversed
    dtLMaster = new CANTalon(22);
    dtRSlave1 = new CANTalon(23); // reversed
    dtLSlave1 = new CANTalon(24); // reversed
    dtRMaster = new CANTalon(25);
    dtLSlave2 = new CANTalon(26);
    intake = new CANTalon(27); // reversed
    climber = new CANTalon(29); // reversed
    shooter = new CANTalon(31);
    gadgetL = new CANTalon(32);
    loader = new CANTalon(33); // reversed
    gadgetR = new CANTalon(34);

    // instantiate pneumatic system
    compressor = new Compressor(50); // device id
    solenoid = new Solenoid(50, 5); // device id, channel

    // instantiate sensors
    dial = new AnalogPotentiometer(2, 300, 0); // channel, range, offset

    // right side slave setup
    dtRSlave1.changeControlMode(TalonControlMode.Follower);
    dtRSlave1.set(dtRMaster.getDeviceID());
    dtRSlave2.changeControlMode(TalonControlMode.Follower);
    dtRSlave2.set(dtRMaster.getDeviceID());

    // left side slave setup
    dtLSlave1.changeControlMode(TalonControlMode.Follower);
    dtLSlave1.set(dtLMaster.getDeviceID());
    dtLSlave2.changeControlMode(TalonControlMode.Follower);
    dtLSlave2.set(dtLMaster.getDeviceID());

    // reverse polarity as required
    dtRSlave1.reverseOutput(true);
    dtRSlave2.reverseOutput(true);
    dtLSlave1.reverseOutput(true);
    climber.reverseOutput(true);
    intake.reverseOutput(true);
    loader.reverseOutput(true);

    // master motors setup
    dtMasterMotors = new RobotDrive(dtLMaster, dtRMaster);
    dtMasterMotors.setSafetyEnabled(true);
    dtMasterMotors.setExpiration(0.2);
    dtMasterMotors.setSensitivity(0.5);
    dtMasterMotors.setMaxOutput(1.0);
    values.put("low_governor", 0.85);
    values.put("high_governor", 1.0);

  }
}
