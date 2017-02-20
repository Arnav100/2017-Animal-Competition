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

  public void intake(double x) {
    ballIntakeLeft.set(x);
    ballIntakeRight.set(-x);
  }

  public void enableBrakeMode() {
    ballIntakeLeft.enableBrakeMode(true);
    ballIntakeRight.enableBrakeMode(true);
  }

  public void disableBrakeMode() {
    ballIntakeLeft.enableBrakeMode(false);
    ballIntakeRight.enableBrakeMode(false);
  }

  public void stop() {
    ballIntakeLeft.set(0);
    ballIntakeRight.set(0);
  }

  protected void initDefaultCommand() {}

  public double getBallIntakeLeft() {
    return ballIntakeLeft.get();
  }
}
