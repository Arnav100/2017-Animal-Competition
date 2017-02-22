package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Record extends Command
{

  private boolean isIntentional = false;

  @Override
  protected void initialize() {
    if (Robot.oi.getJoystick2Button7()) {
      Robot.isRecording = true;
      try {
        Robot.recorder.setupRecorder();
      } catch (Exception e) {
        e.printStackTrace();
      }
      isIntentional = true;
    }
  }

  @Override
  protected void execute() {
    if (isIntentional) {
      try {
        Robot.recorder.record();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  protected boolean isFinished() {
    return !Robot.isRecording;
  }

  @Override
  protected void end() {
    try {
      Robot.recorder.endRecord();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  protected void interrupted() {
    end();
  }
}
