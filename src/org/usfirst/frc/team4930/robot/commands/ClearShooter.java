package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ClearShooter extends Command
{
  public ClearShooter() {
    requires(Robot.shooter);
    requires(Robot.loader);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.shooter.clear();
    Robot.loader.clear();
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.shooter.stop();
    Robot.loader.stop();
  }

  protected void interrupted() {
    end();
  }
}
