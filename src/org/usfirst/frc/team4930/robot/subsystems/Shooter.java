package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem
{
  protected void initDefaultCommand() {}

  public void shoot(double value) {
    RobotMap.shooter.set(value);
  }

  public void clear() {
    double value = RobotMap.values.get("clear_shooter");
    RobotMap.shooter.set(-value);
  }

  public void stop() {
    RobotMap.shooter.set(0.0);
  }

  public double getValue() {
    return RobotMap.shooter.get();
  }

  public void brakeMode(boolean state) {
    RobotMap.shooter.enableBrakeMode(state);
  }
}
