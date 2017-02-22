package org.usfirst.frc.team4930.robot.utilities;

import java.io.*;
import org.usfirst.frc.team4930.robot.Robot;

public class Recorder
{
  // public static final CANTalon driveTrainLeftMaster = RobotMap.driveTrainLeftMaster;
  // public static final CANTalon driveTrainRightMaster = RobotMap.driveTrainRightMaster;

  FileWriter writer;
  long startTime;

  public void setupRecorder() throws IOException {
    // instantiate writer and set startTime
    writer = new FileWriter(Robot.autoFilePath);
    startTime = System.currentTimeMillis();
  }

  public void record() throws IOException {
    // write a timestamp, the motor values, and make a new line
    if (writer != null) {
      writer.append("" + (System.currentTimeMillis() - startTime));
      // driveTrain
      writer.append("," + Robot.oi.j0.getY());
      writer.append("," + Robot.oi.j1.getY());
      // ballIntakev
      // climber
      writer.append("," + Robot.climber.getClimber());
      // loader
      writer.append("," + Robot.loader.getLoader());
      // shooter
      writer.append("," + Robot.shooter.getShooter());
      writer.append("\n");
    }
  }

  public void endRecord() throws IOException {
    // clean up
    if (writer != null) {
      writer.flush();
      writer.close();
    }
  }
}
