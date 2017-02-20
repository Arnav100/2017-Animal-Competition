package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import org.usfirst.frc.team4930.robot.commands.CloseGearGadget;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class GearGadget extends Subsystem
{
  private final CANTalon gearGadgetLeft = RobotMap.gearGadgetLeft;
  private final CANTalon gearGadgetRight = RobotMap.gearGadgetRight;
  // gearGadgetRight is inverted?

  public void initDefaultCommand() {
    setDefaultCommand(new CloseGearGadget());
  }

  public void open() {
    gearGadgetLeft.set(1);
    gearGadgetRight.set(-1);
  }

  public void close() {
    gearGadgetLeft.set(-0.1);
    gearGadgetRight.set(0.1);
  }

  public void enableBrakeMode() {
    gearGadgetLeft.enableBrakeMode(true);
    gearGadgetRight.enableBrakeMode(true);
  }

  public void stop() {
    gearGadgetLeft.set(0);
    gearGadgetRight.set(0);
  }
}
