package org.usfirst.frc.team4930.robot.utilities;

import java.io.*;
import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;

public class ReplayRecorder
{

  private FileWriter writer;
  private long startTime;
  private String alliance;

  // instantiate writer and set the start time
  public void setup() throws IOException {
    writer = new FileWriter(Robot.replayFilePath);
    startTime = System.currentTimeMillis();
    alliance = Robot.toggleSwitch.getSide();
  }

  // write a timestamp, the motor values, then make a new line
  public void record() throws IOException {
    if (writer != null) {
      writer.append("" + (System.currentTimeMillis() - startTime));
      // alliance
      writer.append("," + alliance);
      // record state of shifter
      if (Robot.inLowGear) {
        writer.append("," + "Low");
      } else {
        writer.append("," + "High");
      }
      // drive train left
      writer.append("," + RobotMap.dtLMaster.get());
      // drive train right
      writer.append("," + RobotMap.dtRMaster.get());
      // gear gadget value
      writer.append("," + RobotMap.gadgetL.get());
      // intake value
      writer.append("," + RobotMap.intake.get());
      // loader value
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
