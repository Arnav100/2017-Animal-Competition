package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftToggle extends Command
{
  private static boolean isLowGear = true;

  public ShiftToggle() {
    requires(Robot.pneumatics);
  }

  protected void initialize() {}

  protected void execute() {

    if (isLowGear) {
      Robot.pneumatics.highGear();
      isLowGear = false;
    } else {
      Robot.pneumatics.lowGear();
      isLowGear = true;
    }
  }

  protected boolean isFinished() {
    return true;
  }

  protected void end() {}

  protected void interrupted() {}
}
