package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class LoadShooter extends Command
{
  public LoadShooter() {
    requires(Robot.loader);
  }

  protected void initialize() {}

  protected void execute() {
    if (timeSinceInitialized() > 1.1) {
      Robot.loader.load();
    }
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.loader.stop();
  }

  protected void interrupted() {
    end();
  }
}
