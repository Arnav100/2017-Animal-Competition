package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClearBalls extends Command
{

  public ClearBalls() {
    requires(Robot.shooter);
    requires(Robot.loader);
  }

  protected void initialize() {}

  protected void execute() {
    // Robot.shooter.clearBalls();
    // Robot.loader.clearBalls();
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    // Robot.shooter.stop();
    // Robot.loader.stop();
  }

  protected void interrupted() {
    end();
  }
}
