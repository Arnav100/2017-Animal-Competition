package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shifter extends Subsystem
{
  public void initDefaultCommand() {}

  public void highGear() {
    RobotMap.solenoid.set(true);
  }

  public void lowGear() {
    RobotMap.solenoid.set(false);
  }
}
