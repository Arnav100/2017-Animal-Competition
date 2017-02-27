package org.usfirst.frc.team4930.robot;

import org.usfirst.frc.team4930.robot.autonomous.*;
import org.usfirst.frc.team4930.robot.sensors.Dial;
import org.usfirst.frc.team4930.robot.subsystems.*;
import org.usfirst.frc.team4930.robot.utilities.*;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot
{
  public static OI oi;

  // subsystems and sensors
  public static Climber climber;
  public static Dial dial;
  public static DriveTrain driveTrain;
  public static GearGadget gearGadget;
  public static Intake intake;
  public static Loader loader;
  public static Shifter shifter;
  public static Shooter shooter;

  // auto replay setup
  public static ReplayPlayer replayPlayer;
  public static ReplayRecorder replayRecorder;
  public static Command autoCommand;
  public static String autoSelected;
  public static String replayFilePath = new String("/home/lvuser/CSVs/Replay.csv");

  // robot states
  public static boolean inLowGear = true; // robot must start in low gear!
  public static boolean isRecording = false;
  public static boolean isPlaying = false;

  // test mode setup
  public static CANTalon testMotor;

  public void robotInit() {

    // initialize robot mappings
    RobotMap.init();

    // instatiate drive train first then the rest of the subsystems
    driveTrain = new DriveTrain();
    climber = new Climber();
    gearGadget = new GearGadget();
    intake = new Intake();
    loader = new Loader();
    shifter = new Shifter();
    shooter = new Shooter();
    dial = new Dial();

    // instatiate replay code
    replayPlayer = new ReplayPlayer();
    replayRecorder = new ReplayRecorder();

    // instatiate oi last
    oi = new OI();

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

  public void testInit() {
    testMotor = new CANTalon(34);
  }

  public void testPeriodic() {
    LiveWindow.run();
    testMotor.set(0.4);
  }

}
