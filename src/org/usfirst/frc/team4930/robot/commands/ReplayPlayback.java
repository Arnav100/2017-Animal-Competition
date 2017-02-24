package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ReplayPlayback extends Command
{
  private boolean isIntentional = false;

  protected void initialize() {
    if (Robot.oi.j2b11.get()) {
      try {
        Robot.playbacker.setup();
      } catch (Exception e) {
        e.printStackTrace();
      }
      isIntentional = true;
    }
  }

  protected void execute() {
    if (isIntentional) {
      Robot.playbacker.play();
    }
  }

  protected boolean isFinished() {
    return !Robot.isPlaying;
  }

  protected void end() {
    Robot.playbacker.end();
  }

  protected void interrupted() {
    end();
  }
}
