package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Load extends Command
{

  public Load() {
    requires(Robot.loader);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    Robot.loader.load(0.85);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.loader.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
