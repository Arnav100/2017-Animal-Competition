package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Command;

public class ValueChangeDown extends Command
{

  public String reference;

  public ValueChangeDown(String reference) {
    this.reference = reference;
  }

  protected void initialize() {}

  protected void execute() {
    double value = RobotMap.values.get(reference);
    double newValue = value - 0.1;
    if (newValue > 0.0) {
      RobotMap.values.put(reference, newValue);
    }
  }

  protected boolean isFinished() {
    return true;
  }

  protected void end() {}

  protected void interrupted() {}
}
