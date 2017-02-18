package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Playback extends Command
{

  protected void initialize() {
    if (Robot.oi.getJoystick2Button11()) {
      Robot.isPlaying = true;
      try {
        Robot.playbacker.setupPlayback();
      } catch (Exception e) {
        e.printStackTrace();
      }
    } else {
      end();
    }
  }

  protected void execute() {
    Robot.playbacker.play();
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
