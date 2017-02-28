package org.usfirst.frc.team4930.robot.utilities;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard
{
  public void update() {

    // dial number and selected replay
    SmartDashboard.putString("Dial Number: ", Robot.dialNumber.toString());
    SmartDashboard.putString("Replay Selected: ", Robot.autoDescription);

    // replay is or is not recording
    SmartDashboard.putBoolean("isRecording: ", Robot.isRecording);
    SmartDashboard.putBoolean("isPlaying: ", Robot.isReplaying);

    // sensor data
    SmartDashboard.putNumber("Gyro Angle: ", Robot.gyro.heading());

  }
}
