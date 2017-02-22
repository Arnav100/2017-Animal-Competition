package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import org.usfirst.frc.team4930.robot.commands.CloseGearGadget;

import edu.wpi.first.wpilibj.command.Subsystem;

public class GearGadget extends Subsystem
{
  public void initDefaultCommand() {
    setDefaultCommand(new CloseGearGadget());
  }

  public void open(double amount) {
    RobotMap.gearGadgetL.set(amount);
    RobotMap.gearGadgetR.set(-amount);
  }

  public void enableBrakeMode() {
    RobotMap.gearGadgetL.enableBrakeMode(true);
    RobotMap.gearGadgetR.enableBrakeMode(true);
  }

  public void close() {
    RobotMap.gearGadgetL.set(-0.1);
    RobotMap.gearGadgetR.set(0.1);
  }

  public void stop() {
    RobotMap.gearGadgetL.set(0.0);
    RobotMap.gearGadgetR.set(0.0);
  }

  public double getGearGadgetLeft() {
    return RobotMap.gearGadgetL.get();
  }
}
