package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Agitate extends Command
{
  public Agitate() {
    requires(Robot.intake);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.intake.agitate();
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
