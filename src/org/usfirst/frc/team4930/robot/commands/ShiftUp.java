package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class ShiftUp extends Command
{

  private double gadgetVal = RobotMap.values.get("close_gadget");

  public ShiftUp() {
    requires(Robot.shifter);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.shifter.highGear();
    RobotMap.values.put("close_gadget", gadgetVal * 2);
  }

  protected boolean isFinished() {
    return true;
  }

  protected void end() {
    RobotMap.values.put("close_gadget", gadgetVal);
  }

  protected void interrupted() {
    end();
  }
}
