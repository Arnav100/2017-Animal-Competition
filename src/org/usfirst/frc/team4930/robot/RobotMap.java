package org.usfirst.frc.team4930.robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.*;

public class RobotMap
{
  public static RobotDrive driveTrainMasterMotors;

  public static CANTalon driveTrainLeftMaster;
  public static CANTalon driveTrainLeftSlave1;
  public static CANTalon driveTrainLeftSlave2;

  public static CANTalon driveTrainRightMaster;
  public static CANTalon driveTrainRightSlave1;
  public static CANTalon driveTrainRightSlave2;

  public static CANTalon climber;
  public static CANTalon gearGadgetLeft;
  public static CANTalon gearGadgetRight;

  public static AnalogPotentiometer dialChooser;

  public static Solenoid solenoid;
  public static Compressor compressor;

  public static CANTalon ballIntakeLeft;
  public static CANTalon ballIntakeRight;
  public static CANTalon loader;
  public static CANTalon shooter;

  public static void init() {

    driveTrainRightMaster = new CANTalon(25);
    driveTrainRightSlave1 = new CANTalon(23);
    driveTrainRightSlave2 = new CANTalon(21);

    driveTrainRightSlave1.changeControlMode(TalonControlMode.Follower);
    driveTrainRightSlave1.set(driveTrainRightMaster.getDeviceID());
    driveTrainRightSlave1.reverseOutput(true);

    driveTrainRightSlave2.changeControlMode(TalonControlMode.Follower);
    driveTrainRightSlave2.set(driveTrainRightMaster.getDeviceID());
    driveTrainRightSlave2.reverseOutput(true);

    driveTrainLeftMaster = new CANTalon(22);
    driveTrainLeftSlave1 = new CANTalon(24);
    driveTrainLeftSlave2 = new CANTalon(26);

    driveTrainLeftSlave1.changeControlMode(TalonControlMode.Follower);
    driveTrainLeftSlave1.set(driveTrainLeftMaster.getDeviceID());
    driveTrainLeftSlave1.reverseOutput(true);

    driveTrainLeftSlave2.changeControlMode(TalonControlMode.Follower);
    driveTrainLeftSlave2.set(driveTrainLeftMaster.getDeviceID());

    driveTrainMasterMotors = new RobotDrive(driveTrainLeftMaster, driveTrainRightMaster);
    driveTrainMasterMotors.setSafetyEnabled(true);
    driveTrainMasterMotors.setExpiration(0.1);
    driveTrainMasterMotors.setSensitivity(0.5);
    driveTrainMasterMotors.setMaxOutput(1.0);

    ballIntakeRight = new CANTalon(27);
    climber = new CANTalon(29);
    shooter = new CANTalon(31);
    gearGadgetLeft = new CANTalon(32);
    loader = new CANTalon(33);
    gearGadgetRight = new CANTalon(34);

    solenoid = new Solenoid(50, 5);
    compressor = new Compressor(50);
    dialChooser = new AnalogPotentiometer(2, 300, 0);
  }
}
