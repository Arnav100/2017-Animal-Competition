package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ShiftToggle extends Command
{
  public ShiftToggle() {
    requires(Robot.shifter);
  }

  protected void initialize() {}

  protected void execute() {
    if (Robot.inLowGear) {
      Robot.shifter.highGear();
    } else {
      Robot.shifter.lowGear();
    }
  }

  protected boolean isFinished() {
    return true;
  }

  protected void end() {}

  protected void interrupted() {
    end();
  }
}
