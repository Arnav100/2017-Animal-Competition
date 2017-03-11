package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ReplayRecord extends Command
{
  private boolean isIntentional = false;

  protected void initialize() {
    if (Robot.oi.j2b7.get()) {
      Robot.isRecording = true;
      try {
        Robot.replayRecorder.setup();
        isIntentional = true;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  protected void execute() {
    if (isIntentional) {
      try {
        Robot.replayRecorder.record();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  protected boolean isFinished() {
    return !Robot.isRecording;
  }

  protected void end() {
    try {
      Robot.replayRecorder.end();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void interrupted() {
    end();
  }
}
