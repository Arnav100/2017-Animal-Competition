package org.usfirst.frc.team4930.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class Timer extends Command
{
  public double seconds;

  public Timer(double s) {
    seconds = s;
  }

  protected boolean isFinished() {
    return timeSinceInitialized() > seconds;
  }
}
