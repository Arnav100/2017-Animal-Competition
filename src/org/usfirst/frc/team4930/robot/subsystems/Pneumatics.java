package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Pneumatics extends Subsystem
{

  @Override
  public void initDefaultCommand() {

  }

  public void enableHighGear() {
    RobotMap.solenoid.set(true);
  }

  public void enableLowGear() {
    RobotMap.solenoid.set(false);
  }

}
