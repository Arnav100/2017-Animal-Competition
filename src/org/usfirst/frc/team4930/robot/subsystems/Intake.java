package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem
{
  public void agitate() {
    RobotMap.intake.set(-0.45);
  }

  public void in(double x) {
    RobotMap.intake.set(-x);
  }

  public void out(double x) {
    RobotMap.intake.set(x);
  }

  public void disableBrakeMode() {
    RobotMap.intake.enableBrakeMode(false);
  }

  public void stop() {
    RobotMap.intake.set(0);
  }

  protected void initDefaultCommand() {}
}
