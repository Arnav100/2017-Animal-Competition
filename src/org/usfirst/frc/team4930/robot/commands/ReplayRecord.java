package org.usfirst.frc.team4930.robot.commands;

import java.io.IOException;
import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ReplayRecord extends Command
{

  protected void initialize() {
    Robot.isRecording = true;
    try {
      Robot.replayRecorder.setup();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  protected void execute() {
    try {
      Robot.replayRecorder.record();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  protected boolean isFinished() {
    return !Robot.isRecording;
  }

  protected void end() {
    try {
      Robot.replayRecorder.end();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  protected void interrupted() {
    end();
  }
}
