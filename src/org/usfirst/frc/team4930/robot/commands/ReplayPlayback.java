package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReplayPlayback extends Command
{
  private boolean isIntentional = false;

  protected void initialize() {
    if (Robot.oi.j2b11.get()) {
      Robot.isPlaying = true;
      try {
        Robot.playbacker.setupPlayback();
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
    Robot.playbacker.endPlayback();
  }

  protected void interrupted() {
    end();
  }
}
