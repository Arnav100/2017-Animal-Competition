package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem
{
  protected void initDefaultCommand() {}

  public void move(double value) {
    RobotMap.shooter.set(value);
  }

  public void shoot() {
    move(RobotMap.values.get("shooter"));
  }

  public void clear() {
    move(-RobotMap.values.get("clear_fuel"));
  }

  public void stop() {
    move(0.0);
  }

  public void brakeMode(boolean state) {
    RobotMap.shooter.enableBrakeMode(state);
  }
}
