package org.usfirst.frc.team4930.robot;

import org.usfirst.frc.team4930.robot.sensors.Accelerometer;
import org.usfirst.frc.team4930.robot.sensors.Cameras;
import org.usfirst.frc.team4930.robot.sensors.Dial;
import org.usfirst.frc.team4930.robot.sensors.Encoders;
import org.usfirst.frc.team4930.robot.sensors.Gyro;
import org.usfirst.frc.team4930.robot.sensors.ToggleSwitch;
import org.usfirst.frc.team4930.robot.subsystems.Climber;
import org.usfirst.frc.team4930.robot.subsystems.DriveTrain;
import org.usfirst.frc.team4930.robot.subsystems.GearGadget;
import org.usfirst.frc.team4930.robot.subsystems.Intake;
import org.usfirst.frc.team4930.robot.subsystems.Loader;
import org.usfirst.frc.team4930.robot.subsystems.Shifter;
import org.usfirst.frc.team4930.robot.subsystems.Shooter;
import org.usfirst.frc.team4930.robot.utilities.Dashboard;
import org.usfirst.frc.team4930.robot.utilities.ReplayPlayer;
import org.usfirst.frc.team4930.robot.utilities.ReplayRecorder;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

public class Robot extends IterativeRobot
{

  public static OI oi;
  public static Dashboard dashboard;
  public static CANTalon testMotor;

  // subsystems
  public static Climber climber;
  public static DriveTrain driveTrain;
  public static GearGadget gearGadget;
  public static Intake intake;
  public static Loader loader;
  public static Shifter shifter;
  public static Shooter shooter;

  // sensors
  public static Cameras cameras;
  public static Dial dial;
  public static Encoders encoders;
  public static Gyro gyro;
  public static ToggleSwitch switches;
  public static Accelerometer accel;

  // auto replay setup
  public static Integer dialNumber;
  public static Command autoCommand;
  public static String autoDescription;
  public static String replayFilePath;
  public static ReplayPlayer replayPlayer;
  public static ReplayRecorder replayRecorder;

  // initial robot states
  public static boolean inLowGear = true;
  public static boolean isRecording = false;
  public static boolean isReplaying = false;
  public static boolean isRed = false;
  public static boolean isReplayOn = false;

  public void robotInit() {

    // initialize robot mappings
    RobotMap.init();

    // instantiate drive train first
    Robot.driveTrain = new DriveTrain();

    // instantiate the rest of the subsystems and sensors
    Robot.accel = new Accelerometer();
    Robot.cameras = new Cameras();
    Robot.climber = new Climber();
    Robot.gearGadget = new GearGadget();
    Robot.encoders = new Encoders();
    Robot.intake = new Intake();
    Robot.loader = new Loader();
    Robot.shifter = new Shifter();
    Robot.shooter = new Shooter();
    Robot.dial = new Dial();
    Robot.switches = new ToggleSwitch();
    Robot.gyro = new Gyro();

    // instantiate replay code
    Robot.replayPlayer = new ReplayPlayer();
    Robot.replayRecorder = new ReplayRecorder();

    // instantiate dashboard and oi last
    Robot.oi = new OI();
    Robot.dashboard = new Dashboard();

    // set defaults for sensors
    Robot.encoders.reset();
    Robot.gyro.calibrating();

    // setup USB camera
    // UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    // camera.setResolution(640, 480);
    // camera.setFPS(20);

    // set saftey and brake modes for all talons
    OI.motorControllerSafetyAndBrakes(false, true);
  }

  public void robotPeriodic() {
    Robot.dashboard.update();
  }

  public void autonomousInit() {
    Robot.encoders.reset();
    Robot.autoCommand.start();
  }

  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  public void teleopInit() {
    if (Robot.autoCommand != null) {
      Robot.autoCommand.cancel();
    }
    Robot.encoders.reset();
    Robot.accel.resetMax();
  }

  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    Robot.accel.maxXYZ();
    // Robot.accel.overrideGearGadget();
  }

  public void disabledInit() {
    RobotMap.disableAllTalons();
  }

  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  public void testInit() {
    Robot.testMotor = new CANTalon(30);
  }

  public void testPeriodic() {
    Robot.testMotor.set(0.4);
  }
}
