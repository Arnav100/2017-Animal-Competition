package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ClearBalls extends Command
{

  public ClearBalls() {
    requires(Robot.shooter);
    requires(Robot.loader);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    Robot.shooter.clearBalls();
    Robot.loader.clearBalls();
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.shooter.stop();
    Robot.loader.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
