package org.usfirst.frc.team4930.robot;

import org.usfirst.frc.team4930.robot.autonomous.*;
import org.usfirst.frc.team4930.robot.sensors.Dial;
import org.usfirst.frc.team4930.robot.subsystems.*;
import org.usfirst.frc.team4930.robot.utilities.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

public class Robot extends IterativeRobot
{
  // instantiate all subsystems and sensors
  public static Climber climber = new Climber();
  public static Dial dial = new Dial();
  public static DriveTrain driveTrain = new DriveTrain();
  public static GearGadget gearGadget = new GearGadget();
  public static Intake intake = new Intake();
  public static Loader loader = new Loader();
  public static Playbacker playbacker = new Playbacker();
  public static Pneumatics pneumatics = new Pneumatics();
  public static Recorder recorder = new Recorder();
  public static Shooter shooter = new Shooter();

  // oi is instantiated last
  public static OI oi = new OI();

  // auto replay setup
  public static Command autoCommand;
  public static String autoFilePath = new String("/home/lvuser/CSVs/Replay.csv");
  public static boolean isRecording = false;
  public static boolean isPlaying = false;

  public void robotInit() {

    // initialize robot mappings
    RobotMap.init();

    // set default brake modes
    Robot.intake.brakeMode(false);
    Robot.climber.brakeMode(true);
    Robot.loader.brakeMode(true);
    Robot.gearGadget.brakeMode(true);
    Robot.shooter.brakeMode(false);
  }

  public void autonomousInit() {

    // start auto with brake mode on
    Robot.driveTrain.brakeMode(true);

    // check on board dial for auto
    switch ((int) Dial.getDial()) {
      case 1:
        autoCommand = new NearGear();
        break;
      case 2:
        autoCommand = new NearReplay();
        break;
      case 3:
        autoCommand = new MiddleGear();
        break;
      case 4:
        autoCommand = new MiddleReplay();
        break;
      case 5:
        autoCommand = new FarGear();
        break;
      case 6:
        autoCommand = new FarReplay();
        break;
      default:
        autoCommand = new DoNothing();
    }

    // run selected auto
    autoCommand.start();
  }

  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  public void teleopInit() {

    // cancel auto if not already done
    if (autoCommand != null) {
      autoCommand.cancel();
    }

    // start teleop with brake mode off
    Robot.driveTrain.brakeMode(false);
  }

  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  public void disabledInit() {}

  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

}
