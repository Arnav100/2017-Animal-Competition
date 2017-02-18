package org.usfirst.frc.team4930.robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;

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

    solenoid = new Solenoid(50, 0);
    compressor = new Compressor(50);

    climber = new CANTalon(29);
    climber.enableBrakeMode(true);

    // UNKNOWN TALONS
    gearGadgetLeft = new CANTalon(30);
    gearGadgetRight = new CANTalon(32);
    gearGadgetLeft.enableBrakeMode(true);
    gearGadgetRight.enableBrakeMode(true);

    // right side
    driveTrainRightMaster = new CANTalon(25);
    driveTrainRightSlave1 = new CANTalon(23);
    driveTrainRightSlave2 = new CANTalon(21);

    driveTrainRightSlave1.changeControlMode(TalonControlMode.Follower);
    driveTrainRightSlave1.set(driveTrainRightMaster.getDeviceID());
    driveTrainRightSlave1.reverseOutput(true);

    driveTrainRightSlave2.changeControlMode(TalonControlMode.Follower);
    driveTrainRightSlave2.set(driveTrainRightMaster.getDeviceID());
    driveTrainRightSlave2.reverseOutput(true);

    // left side
    driveTrainLeftMaster = new CANTalon(22);
    driveTrainLeftSlave1 = new CANTalon(24);
    driveTrainLeftSlave2 = new CANTalon(26);

    driveTrainLeftSlave1.changeControlMode(TalonControlMode.Follower);
    driveTrainLeftSlave1.set(driveTrainLeftMaster.getDeviceID());
    driveTrainLeftSlave1.reverseOutput(true);

    driveTrainLeftSlave2.changeControlMode(TalonControlMode.Follower);
    driveTrainLeftSlave2.set(driveTrainLeftMaster.getDeviceID());

    // initialize drive motors
    driveTrainMasterMotors = new RobotDrive(driveTrainLeftMaster, driveTrainRightMaster);
    driveTrainMasterMotors.setSafetyEnabled(true);
    driveTrainMasterMotors.setExpiration(0.1);
    driveTrainMasterMotors.setSensitivity(0.5);
    driveTrainMasterMotors.setMaxOutput(1.0);
    // set brake mode
    driveTrainLeftSlave1.enableBrakeMode(false);
    driveTrainLeftSlave2.enableBrakeMode(false);
    driveTrainRightSlave1.enableBrakeMode(false);
    driveTrainRightSlave2.enableBrakeMode(false);
    driveTrainRightMaster.enableBrakeMode(false);
    driveTrainLeftMaster.enableBrakeMode(false);

    ballIntakeLeft = new CANTalon(28);
    ballIntakeRight = new CANTalon(27);
    loader = new CANTalon(33);
    shooter = new CANTalon(31);
    shooter.enableBrakeMode(false);

    // sensors
    dialChooser = new AnalogPotentiometer(2, 300, 0);

  }
}
