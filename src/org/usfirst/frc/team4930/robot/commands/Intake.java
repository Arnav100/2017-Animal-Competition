package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Intake extends Command
{

  public Intake() {
    requires(Robot.ballIntake);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    Robot.ballIntake.intake(1.0);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.ballIntake.stop();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
