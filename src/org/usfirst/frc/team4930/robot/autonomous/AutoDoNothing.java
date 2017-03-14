package org.usfirst.frc.team4930.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;

public class AutoDoNothing extends Command
{
  public AutoDoNothing() {}

  protected void initialize() {
    System.out.println("AUTO: Initializing DoNothing()");
  }

  protected void execute() {}

  protected boolean isFinished() {
    return true;
  }

  protected void end() {}

  protected void interrupted() {
    end();
  }
}
