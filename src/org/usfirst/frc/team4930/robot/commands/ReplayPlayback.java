package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ReplayPlayback extends Command
{
  private boolean isIntentional = false;

  protected void initialize() {
    if (Robot.oi.j2b11.get()) {
      try {
        Robot.replayPlayer.setup();
        isIntentional = true;
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  protected void execute() {
    if (isIntentional) {
      Robot.replayPlayer.play();
    }
  }

  protected boolean isFinished() {
    return !Robot.isReplaying;
  }

  protected void end() {
    Robot.replayPlayer.end();
  }

  protected void interrupted() {
    end();
  }
}
