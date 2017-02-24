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
  public static ReplayPlayer playbacker = new ReplayPlayer();
  public static Shifter shifter = new Shifter();
  public static ReplayRecorder recorder = new ReplayRecorder();
  public static Shooter shooter = new Shooter();

  // always instantiated last
  public static OI oi = new OI();

  // auto replay setup
  public static Command autoCommand;
  public static String autoSelected;
  public static String replayFilePath = new String("/home/lvuser/CSVs/Replay.csv");

  // robot states
  public static boolean inLowGear = true; // robot must start in low gear!
  public static boolean isRecording = false;
  public static boolean isPlaying = false;

  public void robotInit() {

    // initialize robot mappings
    RobotMap.init();

    // set default brake modes
    Robot.climber.brakeMode(true);
    Robot.gearGadget.brakeMode(true);
    Robot.intake.brakeMode(false);
    Robot.loader.brakeMode(true);
    Robot.shooter.brakeMode(false);
  }

  public void autonomousInit() {

    // start auto with brake mode on
    Robot.driveTrain.brakeMode(true);

    // check on board dial for auto
    switch ((int) Dial.getDial()) {
      case 1:
        autoCommand = new NearGear();
        autoSelected = "(1) New Gear";
        break;
      case 2:
        autoCommand = new MiddleGear();
        autoSelected = "(2) Middle Gear";
        break;
      case 3:
        autoCommand = new FarGear();
        autoSelected = "(3) Far Gear";
        break;
      case 4:
        autoCommand = new NearReplay();
        autoSelected = "(4) Near Replay";
        break;
      case 5:
        autoCommand = new MiddleReplay();
        autoSelected = "(5) Middle Replayr";
        break;
      case 6:
        autoCommand = new FarReplay();
        autoSelected = "(6) Far Replay";
        break;
      default:
        autoCommand = new DoNothing();
        autoSelected = "(0) Do Nothing";
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
