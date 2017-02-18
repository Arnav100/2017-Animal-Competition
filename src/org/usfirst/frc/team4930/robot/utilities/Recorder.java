package org.usfirst.frc.team4930.robot.utilities;

import java.io.FileWriter;
import java.io.IOException;

import org.usfirst.frc.team4930.robot.Robot;

public class Recorder
{
  FileWriter writer;
  long startTime;

  public void setupRecorder() throws IOException {
    // instantiate writer and set startTime
    writer = new FileWriter(Robot.autoFile);
    startTime = System.currentTimeMillis();
  }

  public void record() throws IOException {
    // write a timestamp, the motor values, and make a new line
    if (writer != null) {
      writer.append("" + (System.currentTimeMillis() - startTime));
      writer.append("," + Robot.oi.getJoystick0());
      writer.append("," + Robot.oi.getJoystick1());
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
