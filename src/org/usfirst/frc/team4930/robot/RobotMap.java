package org.usfirst.frc.team4930.robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into to a variable name.
 * This provides flexibility changing wiring, makes checking the wiring easier and significantly
 * reduces the number of magic numbers floating around.
 */
public class RobotMap
{
  public static RobotDrive driveTrainMasterMotors;
  public static CANTalon driveTrainLeftMaster;
  public static CANTalon driveTrainLeftSlave1;
  public static CANTalon driveTrainLeftSlave2;
  public static CANTalon driveTrainRightMaster;
  public static CANTalon driveTrainRightSlave1;
  public static CANTalon driveTrainRightSlave2;

  public static void init() {
    driveTrainRightMaster = new CANTalon(22);
    driveTrainRightSlave1 = new CANTalon(24);
    driveTrainRightSlave2 = new CANTalon(26);
    driveTrainLeftMaster = new CANTalon(21);
    driveTrainLeftSlave1 = new CANTalon(23);
    driveTrainLeftSlave2 = new CANTalon(25);
    // reverse 25
    //
    driveTrainLeftSlave1.changeControlMode(TalonControlMode.Follower);
    driveTrainLeftSlave1.set(driveTrainLeftMaster.getDeviceID());
    driveTrainLeftSlave2.changeControlMode(TalonControlMode.Follower);
    driveTrainLeftSlave2.set(driveTrainLeftMaster.getDeviceID());
    driveTrainRightSlave1.changeControlMode(TalonControlMode.Follower);
    driveTrainRightSlave1.set(driveTrainRightMaster.getDeviceID());
    driveTrainRightSlave2.changeControlMode(TalonControlMode.Follower);
    driveTrainRightSlave2.set(driveTrainRightMaster.getDeviceID());
    //
    driveTrainMasterMotors = new RobotDrive(driveTrainLeftMaster, driveTrainRightMaster);
    driveTrainMasterMotors.setSafetyEnabled(true);
    driveTrainMasterMotors.setExpiration(0.1);
    driveTrainMasterMotors.setSensitivity(0.5);
    driveTrainMasterMotors.setMaxOutput(1.0);
    //
    driveTrainLeftMaster.enableBrakeMode(true);
    driveTrainLeftSlave1.enableBrakeMode(true);
    driveTrainLeftSlave2.enableBrakeMode(true);
    driveTrainRightMaster.enableBrakeMode(true);
    driveTrainRightSlave1.enableBrakeMode(true);
    driveTrainRightSlave2.enableBrakeMode(true);
  }
}
