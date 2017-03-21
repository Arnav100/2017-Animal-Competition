package org.usfirst.frc.team4930.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Autonomous: Do Nothing (literally)
 */
public class Auto000 extends Command
{
  public Auto000() {}

  protected void initialize() {
    System.out.println("AUTO 0: Initializing Do Nothing");
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
