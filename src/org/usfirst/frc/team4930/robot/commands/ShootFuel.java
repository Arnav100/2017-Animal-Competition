package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShootFuel extends Command
{
  public ShootFuel() {
    requires(Robot.shooter);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.shooter.shoot();
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.shooter.stop();
  }

  protected void interrupted() {
    end();
  }
}
