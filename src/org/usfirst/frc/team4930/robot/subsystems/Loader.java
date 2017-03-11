package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Loader extends Subsystem
{
  protected void initDefaultCommand() {}

  public void move(double value) {
    RobotMap.loader.set(value);
  }

  public void load() {
    move(RobotMap.values.get("loader"));
  }

  public void clear() {
    move(-RobotMap.values.get("clear_fuel"));
  }

  public void stop() {
    move(0.0);
  }

  public void brakeMode(boolean state) {
    RobotMap.loader.enableBrakeMode(state);
  }
}
