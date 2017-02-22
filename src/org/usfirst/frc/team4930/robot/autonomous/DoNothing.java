package org.usfirst.frc.team4930.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class DoNothing extends Command
{
  public DoNothing() {}

  protected void initialize() {}

  protected void execute() {}

  protected boolean isFinished() {
    return true;
  }

  protected void end() {}

  protected void interrupted() {
    end();
  }
}
