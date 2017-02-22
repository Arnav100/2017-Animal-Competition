package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftToggle extends Command
{

  private static boolean isLowGear = true;

  public ShiftToggle() {
    requires(Robot.pneumatics);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {

    if (isLowGear) {
      Robot.pneumatics.enableHighGear();
      isLowGear = false;
    } else {
      Robot.pneumatics.enableLowGear();
      isLowGear = true;
    }
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  @Override
  protected void end() {}

  @Override
  protected void interrupted() {}
}
