package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Intake extends Command
{
  public Intake() {
    requires(Robot.intake);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.intake.in(1.0);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.intake.stop();
  }

  protected void interrupted() {
    end();
  }
}
