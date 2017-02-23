package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem
{
  protected void initDefaultCommand() {}

  public void agitate() {
    RobotMap.intake.set(-0.45);
  }

  public void in(double value) {
    RobotMap.intake.set(-value);
  }

  public void out(double value) {
    RobotMap.intake.set(value);
  }

  public void stop() {
    RobotMap.intake.set(0.0);
  }

  public double getValue() {
    return RobotMap.intake.get();
  }

  public void brakeMode(boolean state) {
    RobotMap.intake.enableBrakeMode(state);
  }
}
