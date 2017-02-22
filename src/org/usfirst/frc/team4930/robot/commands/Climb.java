package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Climb extends Command
{
  public static boolean isClimbing = false;

  public Climb() {
    requires(Robot.climber);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    if (!isClimbing) {
      Robot.climber.climb(1.0);
      isClimbing = true;
    } else {
      Robot.climber.stop();
      isClimbing = false;
    }
  }

  @Override
  protected boolean isFinished() {
    return !isClimbing;
  }

  @Override
  protected void end() {
    Robot.climber.stop();
  }

  @Override
  protected void interrupted() {}
}
