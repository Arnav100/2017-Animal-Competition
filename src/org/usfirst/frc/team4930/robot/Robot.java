package org.usfirst.frc.team4930.robot;

import org.usfirst.frc.team4930.robot.autonomous.*;
import org.usfirst.frc.team4930.robot.subsystems.*;
import org.usfirst.frc.team4930.robot.utilities.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot
{
  public static BallIntake ballIntake;
  public static Climber climber;
  public static Dial dial;
  public static DriveTrain driveTrain;
  public static GearGadget gearGadget;
  public static Loader loader;
  public static OI oi;
  public static Playbacker playbacker;
  public static Pneumatics pneumatics;
  public static Recorder recorder;
  public static Shooter shooter;

  public static String autoFile = "TestReplay";
  public static String autoFilePath = new String("/home/lvuser/CSVs/" + autoFile + ".csv");
  public static boolean isRecording = false;
  public static boolean isPlaying = false;
  public static boolean orientation = true;

  public static Command autoCommand;
  public static CommandGroup AutoFarGear;
  public static Command AutoFarReplay;
  public static CommandGroup AutoMiddleGear;
  public static Command AutoMiddleReplay;
  public static CommandGroup AutoNearGear;
  public static Command AutoNearReplay;

  public static CANTalon testMotor;

  @Override
  public void robotInit() {
    RobotMap.init();

    ballIntake = new BallIntake();
    climber = new Climber();
    dial = new Dial();
    driveTrain = new DriveTrain();
    gearGadget = new GearGadget();
    loader = new Loader();
    playbacker = new Playbacker();
    pneumatics = new Pneumatics();
    recorder = new Recorder();
    shooter = new Shooter();

    oi = new OI();

    Robot.ballIntake.disableBrakeMode();
    Robot.climber.enableBrakeMode();
    Robot.loader.enableBrakeMode();
    Robot.gearGadget.enableBrakeMode();
    Robot.shooter.disableBrakeMode();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {

    Robot.driveTrain.toggleBrakeMode(true);

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

  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();

  }

  @Override
  public void teleopInit() {
    if (autoCommand != null) {
      autoCommand.cancel();
    }
    Robot.driveTrain.toggleBrakeMode(false);
  }

  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    SmartDashboard.putBoolean("isClimbing:", true);
  }

  @Override
  public void testInit() {
    testMotor = new CANTalon(32);
  }

  @Override
  public void testPeriodic() {
    LiveWindow.run();
    testMotor.enableBrakeMode(false);
    testMotor.set(0.5);
    Timer.delay(5);
    testMotor.set(0.0);
    Timer.delay(30);
  }
}
