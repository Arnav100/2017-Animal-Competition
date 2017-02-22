package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Playback extends Command
{

  private boolean isIntentional = false;

  @Override
  protected void initialize() {
    if (Robot.oi.getJoystick2Button11()) {
      Robot.isPlaying = true;
      try {
        Robot.playbacker.setupPlayback();
      } catch (Exception e) {
        e.printStackTrace();
      }
      isIntentional = true;
    }
  }

  @Override
  protected void execute() {
    if (isIntentional) {
      Robot.playbacker.play();
    }
  }

  @Override
  protected boolean isFinished() {
    return !Robot.isPlaying;
  }

  @Override
  protected void end() {
    Robot.playbacker.endPlayback();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
