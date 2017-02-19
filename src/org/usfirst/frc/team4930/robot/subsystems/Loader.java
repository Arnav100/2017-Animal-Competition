package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Loader extends Subsystem
{
  private final CANTalon loader = RobotMap.loader;
  // loader is inverted

  public void load() {
    loader.set(-0.9);
  }

  public void clearBalls() {
    loader.set(0.9);
  }

  public void stop() {
    loader.set(0);
  }

  protected void initDefaultCommand() {}
}
