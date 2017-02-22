package org.usfirst.frc.team4930.robot;

import java.util.HashMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.*;

public class RobotMap
{
  // drive train motor controllers
  public static RobotDrive dtMasterMotors;
  public static CANTalon dtRSlave2 = new CANTalon(21);
  public static CANTalon dtLMaster = new CANTalon(22);
  public static CANTalon dtRSlave1 = new CANTalon(23);
  public static CANTalon dtLSlave1 = new CANTalon(24);
  public static CANTalon dtRMaster = new CANTalon(25);
  public static CANTalon dtLSlave2 = new CANTalon(26);

  // subsystem motor controllers
  public static CANTalon intake = new CANTalon(27);
  public static CANTalon climber = new CANTalon(29);
  public static CANTalon shooter = new CANTalon(31);
  public static CANTalon gadgetL = new CANTalon(32);
  public static CANTalon loader = new CANTalon(33);
  public static CANTalon gadgetR = new CANTalon(34);

  // robot pneumatic system
  public static Compressor compressor = new Compressor(50);
  public static Solenoid solenoid = new Solenoid(50, 5);

  // robot sensors
  public static AnalogPotentiometer dial = new AnalogPotentiometer(2, 300, 0);

  // static values
  public static HashMap<String, Double> values = new HashMap<String, Double>();

  public static void init() {

    // organized static values
    values.put("shooting", 0.9);

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

    // master motors setup
    dtMasterMotors = new RobotDrive(dtLMaster, dtRMaster);
    dtMasterMotors.setSafetyEnabled(true);
    dtMasterMotors.setExpiration(0.1);
    dtMasterMotors.setSensitivity(0.5);
    dtMasterMotors.setMaxOutput(1.0);

  }
}
