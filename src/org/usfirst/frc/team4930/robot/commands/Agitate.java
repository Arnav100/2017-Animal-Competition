package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Agitate extends Command
{

  public Agitate() {
    requires(Robot.ballIntake);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.ballIntake.agitate();
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.ballIntake.stop();
  }

  protected void interrupted() {
    end();
  }
}
