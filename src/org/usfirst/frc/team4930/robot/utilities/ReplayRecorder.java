package org.usfirst.frc.team4930.robot.utilities;

import java.io.*;
import org.usfirst.frc.team4930.robot.Robot;

// CSV Replay File Sequence
// (0) long timestamp
// (1) string alliance "Red"/"Blue"
// (2) string shifter "Low"/"High"
// (3) double dtLMaster
// (4) double dtRMaster
// (5) double gadgetL
// (6) double gadgetR
// (7) double intake
// (8) double loader
// (9) double shooter

public class ReplayRecorder
{

  private FileWriter writer;
  private long startTimestamp;
  private String alliance;

  // instantiate writer and set the start time
  public void setup() throws IOException {
    writer = new FileWriter(Robot.replayFilePath);
    alliance = Robot.allianceToggle.getSide();
    startTimestamp = System.currentTimeMillis();
    Robot.isRecording = true;
  }

  // write a timestamp, the motor values, then make a new line
  public void record() throws IOException {
    if (writer != null) {
      writer.append("" + (System.currentTimeMillis() - startTimestamp));
      // alliance
      writer.append("," + alliance);
      // drive train left
      writer.append("," + Robot.oi.j0.getY());
      // create a new line
      writer.append("\n");
    }
  }

  // stop writing to file
  public void end() throws IOException {
    Robot.isRecording = false;
    if (writer != null) {
      writer.flush();
      writer.close();
    }
  }
}
