package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class IntakeFuel extends Command
{
  public IntakeFuel() {
    requires(Robot.intake);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.intake.in();
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
