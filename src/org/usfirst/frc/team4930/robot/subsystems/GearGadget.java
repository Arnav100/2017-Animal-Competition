package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import org.usfirst.frc.team4930.robot.commands.CloseGearGadget;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearGadget extends Subsystem
{

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public void initDefaultCommand() {
    setDefaultCommand(new CloseGearGadget());
  }

  public void open(double amount) {
    RobotMap.gearGadgetLeft.set(amount);
    RobotMap.gearGadgetRight.set(-amount);
  }

  public void enableBrakeMode() {
    RobotMap.gearGadgetLeft.enableBrakeMode(true);
    RobotMap.gearGadgetRight.enableBrakeMode(true);
  }

  public void close() {
    RobotMap.gearGadgetLeft.set(-0.1);
    RobotMap.gearGadgetRight.set(0.1);
  }

  public void stop() {
    RobotMap.gearGadgetLeft.set(0.0);
    RobotMap.gearGadgetRight.set(0.0);
  }

  public double getGearGadgetLeft() {
    return RobotMap.gearGadgetLeft.get();
  }
}
