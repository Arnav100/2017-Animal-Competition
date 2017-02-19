package org.usfirst.frc.team4930.robot;

import org.usfirst.frc.team4930.robot.command.autonomous.FarGear;
import org.usfirst.frc.team4930.robot.command.autonomous.FarReplay;
import org.usfirst.frc.team4930.robot.command.autonomous.MiddleGear;
import org.usfirst.frc.team4930.robot.command.autonomous.MiddleReplay;
import org.usfirst.frc.team4930.robot.command.autonomous.NearGear;
import org.usfirst.frc.team4930.robot.command.autonomous.NearReplay;
import org.usfirst.frc.team4930.robot.subsystems.BallIntake;
import org.usfirst.frc.team4930.robot.subsystems.Climber;
import org.usfirst.frc.team4930.robot.subsystems.Dial;
import org.usfirst.frc.team4930.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4930.robot.subsystems.GearGadget;
import org.usfirst.frc.team4930.robot.subsystems.Loader;
import org.usfirst.frc.team4930.robot.subsystems.Pneumatics;
import org.usfirst.frc.team4930.robot.subsystems.Shooter;
import org.usfirst.frc.team4930.robot.utilities.Playbacker;
import org.usfirst.frc.team4930.robot.utilities.Recorder;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the IterativeRobot documentation. If you change the name of this class
 * or the package after creating this project, you must also update the manifest file in the
 * resource directory.
 */
public class Robot extends IterativeRobot
{
  public static OI oi;
  public static DriveTrain driveTrain;
  public static Pneumatics pneumatics;
  public static Climber climber;
  public static GearGadget gearGadget;
  public static Dial dial;

  public static Recorder recorder;
  public static Playbacker playbacker;
  public static String autoFile = "TestReplay";
  public static String autoFilePath = new String("/home/lvuser/CSVs/" + autoFile + ".csv");
  public static boolean isRecording;
  public static boolean isPlaying;

  public static Command autoCommand;
  public static CommandGroup AutoFarGear;
  public static Command AutoFarReplay;
  public static CommandGroup AutoMiddleGear;
  public static Command AutoMiddleReplay;
  public static CommandGroup AutoNearGear;
  public static Command AutoNearReplay;

  public static BallIntake ballIntake;
  public static Loader loader;
  public static Shooter shooter;

  public static CANTalon motor;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    RobotMap.init();

    dial = new Dial();
    driveTrain = new DriveTrain();
    ballIntake = new BallIntake();
    loader = new Loader();
    shooter = new Shooter();
    recorder = new Recorder();
    playbacker = new Playbacker();
    pneumatics = new Pneumatics();
    climber = new Climber();
    gearGadget = new GearGadget();
    oi = new OI();

    isRecording = false;
    isPlaying = false;

    Robot.ballIntake.enableBrakeMode();
    Robot.climber.enableBrakeMode();
    Robot.gearGadget.enableBrakeMode();
    Robot.loader.enableBrakeMode();
    Robot.shooter.disableBrakeMode();

  }

  /**
   * This function is called once each time the robot enters Disabled mode. You can use it to reset
   * any subsystem information you want to clear when the robot is disabled.
   */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString code to get the auto name from the text box below the Gyro
   *
   * You can add additional auto modes by adding additional commands to the chooser code above (like
   * the commented example) or additional comparisons to the switch structure below with additional
   * strings & commands.
   */
  @Override
  public void autonomousInit() {

    Robot.driveTrain.enableBrakeMode(true);

    AutoFarGear = new FarGear();
    AutoFarReplay = new FarReplay();
    AutoMiddleGear = new MiddleGear();
    AutoMiddleReplay = new MiddleReplay();
    AutoNearGear = new NearGear();
    AutoNearReplay = new NearReplay();

    switch ((int) Dial.getDial()) {
      case 1:
        autoCommand = AutoNearGear;
        break;
      case 2:
        autoCommand = AutoNearReplay;
        break;
      case 3:
        autoCommand = AutoMiddleGear;
        break;
      case 4:
        autoCommand = AutoMiddleReplay;
        break;
      case 5:
        autoCommand = AutoFarGear;
        break;
      case 6:
        autoCommand = AutoFarReplay;
        break;
    }
    autoCommand.start();
  }

  /**
   * This function is called periodically during autonomous
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();

  }

  @Override
  public void teleopInit() {
    if (autoCommand != null) {
      autoCommand.cancel();
    }
    Robot.driveTrain.enableBrakeMode(false);
  }

  /**
   * This function is called periodically during operator control
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();

  }

  public void testInit() {
    motor = new CANTalon(31);

    SmartDashboard.putBoolean("isRecording: ", isRecording);
    SmartDashboard.putBoolean("isPlaying: ", isPlaying);

    autoFilePath = new String("/home/lvuser/CSVs/" + autoFile + ".csv");
    SmartDashboard.putString("autoFile: ", autoFile);
    SmartDashboard.putString("autoFilePath: ", autoFilePath);

    SmartDashboard.putBoolean("solenoid value", RobotMap.solenoid.get());

    SmartDashboard.putNumber("Current Dial Numer ", Dial.getDial());
    SmartDashboard.putNumber("Dial degrees", RobotMap.dialChooser.get());
  }

  /**
   * This function is called periodically during test mode
   */
  @Override
  public void testPeriodic() {
    LiveWindow.run();
    motor.enableBrakeMode(true);
    motor.set(0.8);
    Timer.delay(5);
    motor.set(0.0);
    Timer.delay(3);
    motor.enableBrakeMode(false);
    motor.set(0.8);
    Timer.delay(5);
    motor.set(0.0);
    Timer.delay(10);
    motor.set(0.5);
  }
}
