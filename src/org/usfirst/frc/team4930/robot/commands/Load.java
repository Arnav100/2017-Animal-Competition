package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Load extends Command
{

  public Load() {
    requires(Robot.loader);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.loader.load(0.9);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.loader.stop();
  }

  protected void interrupted() {
    end();
  }
}
