package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ReplayPlayback extends Command
{
  private boolean isIntentional = false;

  protected void initialize() {
    if (Robot.oi.j2b7.get()) {
      try {
        Robot.replayPlayer.setup();
      } catch (Exception e) {
        e.printStackTrace();
      }
      isIntentional = true;
    }
  }

  protected void execute() {
    if (isIntentional) {
      Robot.replayPlayer.play();
    }
  }

  protected boolean isFinished() {
    return !Robot.isPlaying;
  }

  protected void end() {
    Robot.replayPlayer.end();
  }

  protected void interrupted() {
    end();
  }
}
