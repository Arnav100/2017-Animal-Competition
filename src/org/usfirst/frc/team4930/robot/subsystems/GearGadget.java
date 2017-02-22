package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import org.usfirst.frc.team4930.robot.commands.CloseGearGadget;
import edu.wpi.first.wpilibj.command.Subsystem;

public class GearGadget extends Subsystem
{
  public void initDefaultCommand() {
    setDefaultCommand(new CloseGearGadget());
  }

  public void open(double power) {
    RobotMap.gadgetL.set(power);
    RobotMap.gadgetR.set(-power);
  }

  public void close() {
    RobotMap.gadgetL.set(-0.05);
    RobotMap.gadgetR.set(0.05);
  }

  public void stop() {
    RobotMap.gadgetL.set(0.0);
    RobotMap.gadgetR.set(0.0);
  }

  public void brakeMode(boolean state) {
    RobotMap.gadgetL.enableBrakeMode(state);
    RobotMap.gadgetR.enableBrakeMode(state);
  }
}
