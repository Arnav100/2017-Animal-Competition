package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class PlaceGear extends Command
{
  public PlaceGear() {
    requires(Robot.gearGadget);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.gearGadget.open();
  }

  protected boolean isFinished() {
    return timeSinceInitialized() > 0.3;
  }

  protected void end() {
    new CloseGearGadget().start();
  }

  protected void interrupted() {
    end();
  }
}
