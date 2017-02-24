package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command
{
  public TankDrive() {
    requires(Robot.driveTrain);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.driveTrain.drive();
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.driveTrain.stop();
  }

  protected void interrupted() {
    end();
  }
}
