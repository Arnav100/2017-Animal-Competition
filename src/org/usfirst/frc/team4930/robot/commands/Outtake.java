package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Outtake extends Command
{

  public Outtake() {
    requires(Robot.ballIntake);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    Robot.ballIntake.outtake(0.9);
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
