package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class AutoReplay extends Command
{
  public AutoReplay() {}

  protected void initialize() {}

  protected void execute() {
    Robot.replayPlayer.play();
  }

  protected boolean isFinished() {
    return true;
  }

  protected void end() {}

  protected void interrupted() {
    end();
  }
}
