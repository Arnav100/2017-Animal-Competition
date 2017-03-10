package org.usfirst.frc.team4930.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Spin using a gyroscope (bang bang control)
 */
public class SpinBB extends Command
{

  public SpinBB() {}

  protected void initialize() {}

  protected void execute() {}

  protected boolean isFinished() {
    return false;
  }

  protected void end() {}

  protected void interrupted() {
    end();
  }
}
