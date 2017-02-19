package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem
{
  private final CANTalon shooter = RobotMap.shooter;

  public void spinUp() {
    shooter.set(1);
  }

  public void clearBalls() {
    shooter.set(-0.9);
  }

  public void stop() {
    shooter.set(0);
  }

  protected void initDefaultCommand() {}
}
