package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class StopRecord extends Command
{

  @Override
  protected void initialize() {
    if (Robot.oi.getJoystick2Button9()) {
      Robot.isRecording = false;
    }
  }

  @Override
  protected void execute() {}

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {}

  @Override
  protected void interrupted() {
    end();
  }
}
