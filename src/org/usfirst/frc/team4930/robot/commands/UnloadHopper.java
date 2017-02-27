package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class UnloadHopper extends Command
{
  public UnloadHopper() {
    requires(Robot.intake);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.intake.out();
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
