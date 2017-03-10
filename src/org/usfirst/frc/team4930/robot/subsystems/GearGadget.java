package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.*;
import org.usfirst.frc.team4930.robot.commands.CloseGearGadget;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearGadget extends Subsystem
{
  public void initDefaultCommand() {
    setDefaultCommand(new CloseGearGadget());
  }

  public void move(double value) {
    RobotMap.gadgetL.set(-value);
    RobotMap.gadgetR.set(value);
  }

  public void open() {
    move(-RobotMap.values.get("open_gadget"));
  }

  public void close() {
    move(RobotMap.values.get("close_gadget"));
  }

  public void brakeMode(boolean state) {
    RobotMap.gadgetL.enableBrakeMode(state);
    RobotMap.gadgetR.enableBrakeMode(state);
  }
}
