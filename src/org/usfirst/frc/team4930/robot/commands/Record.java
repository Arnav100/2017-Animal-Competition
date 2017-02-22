package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Record extends Command
{
  private boolean isIntentional = false;

  protected void initialize() {
    if (Robot.oi.j2b7.get()) {
      Robot.isRecording = true;
      try {
        Robot.recorder.setupRecorder();
      } catch (Exception e) {
        e.printStackTrace();
      }
      isIntentional = true;
    }
  }

  protected void execute() {
    if (isIntentional) {
      try {
        Robot.recorder.record();
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
      Robot.recorder.endRecord();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  protected void interrupted() {
    end();
  }
}
