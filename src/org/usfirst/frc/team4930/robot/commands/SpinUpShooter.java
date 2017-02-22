package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpinUpShooter extends Command
{

  public SpinUpShooter() {
    requires(Robot.shooter);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    Robot.shooter.spinUp(0.9);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.shooter.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
