package org.usfirst.frc.team4930.robot;

import org.usfirst.frc.team4930.robot.sensors.*;
import org.usfirst.frc.team4930.robot.subsystems.*;
import org.usfirst.frc.team4930.robot.utilities.*;
import com.ctre.CANTalon;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class Robot extends IterativeRobot
{

  public static OI oi;
  public static Dashboard dashboard;
  public static CANTalon testMotor;

  // subsystems
  public static Motor motor;

  // sensors
  public static Dial dial;
  // public static Encoders encoders;
  public static Gyro gyro;
  public static ToggleSwitch allianceToggle;
  public static Shifter shifter;

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
  public static boolean isAuto = false;

  public void robotInit() {

    // initialize robot mappings
    RobotMap.init();

    // instantiate the rest of the subsystems and sensors
    shifter = new Shifter();
    // encoders = new Encoders();
    motor = new Motor();
    dial = new Dial();
    allianceToggle = new ToggleSwitch();
    gyro = new Gyro();

    // instantiate replay code
    replayPlayer = new ReplayPlayer();
    replayRecorder = new ReplayRecorder();

    // instantiate dashboard and oi last
    oi = new OI();
    dashboard = new Dashboard();

    // set default settings for subsystems and sensors
    // Robot.motor.brakeMode(true);
    Robot.gyro.calibrating();

    // setup USB camera
    UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
    camera.setResolution(640, 480);
    camera.setFPS(30);

  }

  public void autonomousInit() {
    dial.setSelectedReplay();
    isAuto = true;
    autoCommand.start();
  }

  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  public void teleopInit() {
    isAuto = false;
    if (autoCommand != null) {
      autoCommand.cancel();
    }
    // Robot.encoders.reset();
  }

  public void teleopPeriodic() {
    Scheduler.getInstance().run();
    dial.setSelectedReplay();
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
