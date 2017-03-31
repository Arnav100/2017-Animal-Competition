package org.usfirst.frc.team4930.robot.utilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.usfirst.frc.team4930.robot.OI;
import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;

public class ReplayRecorder
{

  private FileWriter writer;
  private long startTimestamp;
  private String alliance;

  // instantiate writer and set the start time
  public void setup() throws IOException {
    writer = new FileWriter(Robot.replayFilePath + ".csv");
    moveFile();
    alliance = Robot.switches.getAlliance();
    startTimestamp = System.currentTimeMillis();
    Robot.isRecording = true;
    OI.motorControllerSafetyAndBrakes(false, false);
  }

  public void moveFile() throws IOException {
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    String time = dateFormat.format(date);
    File original = new File(Robot.replayFilePath + ".csv");
    File backUp = new File("../backups/" + Robot.replayFilePath + time + ".csv");
    original.renameTo(backUp);
  }

  // write a timestamp, the motor values, then make a new line
  public void record() throws IOException {
    if (timeToStop()) {
      end();
    }
    if (writer != null) {
      writer.append("" + (System.currentTimeMillis() - startTimestamp));
      // alliance
      writer.append("," + alliance);
      // drive train left
      writer.append("," + Robot.oi.j0.getY());
      // drive train right
      writer.append("," + Robot.oi.j1.getY());
      // gear gadget left value
      writer.append("," + RobotMap.gadgetL.get());
      // gear gadget right value
      writer.append("," + RobotMap.gadgetR.get());
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
    Robot.isRecording = false;
    if (writer != null) {
      writer.flush();
      writer.close();
    }
    OI.motorControllerSafetyAndBrakes(false, true);
  }

  public boolean timeToStop() {
    if ((System.currentTimeMillis() - startTimestamp) >= 15000)
      return true;
    return false;
  }
}
