package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Loader extends Subsystem
{
  protected void initDefaultCommand() {}

  public void load(double amount) {
    RobotMap.loader.set(-amount);
  }

  public void clear() {
    RobotMap.loader.set(0.9);
  }

  public void stop() {
    RobotMap.loader.set(0);
  }

  public double getLoader() {
    return -RobotMap.loader.get();
  }

  public void brakeMode(boolean state) {
    RobotMap.loader.enableBrakeMode(state);
  }
}
