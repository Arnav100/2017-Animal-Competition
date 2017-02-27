package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CloseGearGadget extends Command
{
  public CloseGearGadget() {
    requires(Robot.gearGadget);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.gearGadget.close();
  }

  protected boolean isFinished() {
    return false;
  }

  protected void interrupted() {
    end();
  }
}
