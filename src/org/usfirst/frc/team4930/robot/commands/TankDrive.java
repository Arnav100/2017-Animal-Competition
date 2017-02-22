package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command
{
  public TankDrive() {
    requires(Robot.driveTrain);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    Robot.driveTrain.move(Robot.oi.getJoystick0(), Robot.oi.getJoystick1());
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
    Robot.driveTrain.stop();
  }

  @Override
  protected void interrupted() {
    Robot.driveTrain.stop();
  }
}
