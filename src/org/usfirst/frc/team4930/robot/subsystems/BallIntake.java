package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

public class BallIntake extends Subsystem
{
  private final CANTalon ballIntakeLeft = RobotMap.ballIntakeLeft;
  private final CANTalon ballIntakeRight = RobotMap.ballIntakeRight;
  // ballIntakeRight is inverted

  public void agitate() {
    ballIntakeLeft.set(0.6);
    ballIntakeRight.set(-0.6);
  }

  public void intake() {
    ballIntakeLeft.set(0.9);
    ballIntakeRight.set(-0.9);
  }

  public void stop() {
    ballIntakeLeft.set(0);
    ballIntakeRight.set(0);
  }

  protected void initDefaultCommand() {}
}
