package org.usfirst.frc.team4930.robot;

import org.usfirst.frc.team4930.robot.autonomous.AutoDoNothing;
import org.usfirst.frc.team4930.robot.sensors.*;
import org.usfirst.frc.team4930.robot.subsystems.*;
import org.usfirst.frc.team4930.robot.utilities.*;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot
{

  public static OI oi;
  public static Dashboard dashboard;
  public static CANTalon testMotor;

  // subsystems and sensors
  public static Climber climber;
  public static Dial dial;
  public static DriveTrain driveTrain;
  public static GearGadget gearGadget;
  public static Gyro gyro;
  public static Intake intake;
  public static Loader loader;
  public static Shifter shifter;
  public static Shooter shooter;

  // auto replay setup
  public static Integer dialNumber;
  public static Command autoCommand;
  public static String autoDescription;
  public static String replayFilePath;
  public static ReplayPlayer replayPlayer;
  public static ReplayRecorder replayRecorder;

  // initial robot states
  public static boolean inLowGear = true; // robot must start in low gear!
  public static boolean isRecording = false;
  public static boolean isReplaying = false;

  public void robotInit() {

    // initialize robot mappings
    RobotMap.init();
    dashboard = new Dashboard();

    // instantiate drive train first
    driveTrain = new DriveTrain();

    // instantiate the rest of the subsystems
    climber = new Climber();
    gearGadget = new GearGadget();
    intake = new Intake();
    loader = new Loader();
    shifter = new Shifter();
    shooter = new Shooter();
    dial = new Dial();
    gyro = new Gyro();

    // instantiate replay code
    replayPlayer = new ReplayPlayer();
    replayRecorder = new ReplayRecorder();

    // instantiate oi last
    oi = new OI();

    // set default brake modes
    Robot.climber.brakeMode(true);
    Robot.gearGadget.brakeMode(true);
    Robot.intake.brakeMode(false);
    Robot.loader.brakeMode(true);
    Robot.shooter.brakeMode(false);

    // set default auto to literally do nothing
    dialNumber = 0;
    autoDescription = "(0) Do Nothing";
    autoCommand = new AutoDoNothing();

  }

  public void autonomousInit() {

    // always start auto with brake mode on
    Robot.driveTrain.brakeMode(true);

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

    // always start teleop with brake mode off
    Robot.driveTrain.brakeMode(false);
  }

  public void teleopPeriodic() {
    Scheduler.getInstance().run();

    // set selected auto mode from dial
    dial.setSelectedReplay();

    // update dashboard values
    dashboard.update();
  }

  public void disabledInit() {}

  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  public void testInit() {
    testMotor = new CANTalon(21);
  }

  public void testPeriodic() {
    LiveWindow.run();
    testMotor.set(0.4);
  }
}
