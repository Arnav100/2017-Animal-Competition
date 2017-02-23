package org.usfirst.frc.team4930.robot.utilities;

import java.io.*;
import org.usfirst.frc.team4930.robot.Robot;

public class Recorder
{

  private FileWriter writer;
  private long startTime;

  // instantiate writer and set the start time
  public void setupRecorder() throws IOException {
    writer = new FileWriter(Robot.replayFilePath);
    startTime = System.currentTimeMillis();
  }

  // write a timestamp, the motor values, then make a new line
  public void record() throws IOException {
    if (writer != null) {
      writer.append("" + (System.currentTimeMillis() - startTime));
      // Red/Blue side
      writer.append("," + "R");
      // driver joystick-y values
      writer.append("," + Robot.oi.j0.getY());
      writer.append("," + Robot.oi.j1.getY());
      // intake value
      writer.append("," + Robot.intake.getValue());
      // gear gadget value
      writer.append("," + Robot.gearGadget.getValue());
      // loader value
      writer.append("," + Robot.loader.getLoader());
      // shooter value
      writer.append("," + Robot.shooter.getValue());
      // create a new line
      writer.append("\n");
    }
  }

  // stop writing to file
  public void endRecord() throws IOException {
    if (writer != null) {
      writer.flush();
      writer.close();
    }
  }
}
