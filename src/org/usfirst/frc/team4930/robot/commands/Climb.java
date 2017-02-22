package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command
{

  public Climb() {
    requires(Robot.climber);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    Robot.climber.climb(1.0);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.climber.stop();
  }

  @Override
  protected void interrupted() {}

}
