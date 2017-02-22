package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem
{
  protected void initDefaultCommand() {}

  public void spinUp(double amount) {
    RobotMap.shooter.set(amount);
  }

  public void clearBalls() {
    double value = RobotMap.values.get("shooting");
    RobotMap.shooter.set(-value);
  }

  public void stop() {
    RobotMap.shooter.set(0);
  }

  public double getShooter() {
    return RobotMap.shooter.get();
  }

  public void brakeMode(boolean state) {
    RobotMap.shooter.enableBrakeMode(state);
  }
}
