package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class RotateMotor extends Command
{
  public RotateMotor() {
    requires(Robot.motor);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.motor.move(1.0);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.motor.stop();
  }

  protected void interrupted() {
    end();
  }
}
