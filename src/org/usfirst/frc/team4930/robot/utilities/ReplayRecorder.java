package org.usfirst.frc.team4930.robot.utilities;

import java.io.*;
import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;

public class ReplayRecorder
{

  private FileWriter writer;
  private long startTime;
  private double governor;
  private String alliance;

  // instantiate writer and set the start time
  public void setup() throws IOException {
    writer = new FileWriter(Robot.replayFilePath);
    startTime = System.currentTimeMillis();
    governor = RobotMap.values.get("governor");
    alliance = "Red";
  }

  // write a timestamp, the motor values, then make a new line
  public void record() throws IOException {
    if (writer != null) {
      writer.append("" + (System.currentTimeMillis() - startTime));
      // alliance
      writer.append("," + alliance);
      // drive train values
      writer.append("," + Robot.oi.j0.getY() * governor);
      writer.append("," + Robot.oi.j1.getY() * governor);
      // intake value
      writer.append("," + RobotMap.gadgetL.get());
      // loader value
      writer.append("," + RobotMap.intake.get());
      // gear gadget value
      writer.append("," + RobotMap.loader.get());
      // shooter value
      writer.append("," + RobotMap.shooter.get());
      // create a new line
      writer.append("\n");
    }
  }

  // stop writing to file
  public void end() throws IOException {
    if (writer != null) {
      writer.flush();
      writer.close();
    }
  }
}
