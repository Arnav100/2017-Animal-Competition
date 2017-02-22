package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Loader extends Subsystem
{

  private final CANTalon loader = RobotMap.loader;

  public void load(double amount) {
    loader.set(-amount);
  }

  public void clearBalls() {
    loader.set(0.9);
  }

  public void enableBrakeMode() {
    loader.enableBrakeMode(true);
  }

  public void stop() {
    loader.set(0);
  }

  @Override
  protected void initDefaultCommand() {}

  public double getLoader() {
    return -loader.get();
  }
}
