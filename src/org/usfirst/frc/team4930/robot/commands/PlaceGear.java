package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class PlaceGear extends Command
{

  public PlaceGear() {
    requires(Robot.gearGadget);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    Robot.gearGadget.open(1);
  }

  @Override
  protected boolean isFinished() {
    return timeSinceInitialized() > 0.1;
  }

  @Override
  protected void end() {
    Robot.gearGadget.stop();
    new CloseGearGadget().start();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
