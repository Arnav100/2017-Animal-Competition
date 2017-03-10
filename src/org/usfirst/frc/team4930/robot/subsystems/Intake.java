package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem
{
  protected void initDefaultCommand() {}

  public void move(double value) {
    RobotMap.intake.set(value);
  }

  public void agitate() {
    move(RobotMap.values.get("agitate"));
  }

  public void in() {
    move(RobotMap.values.get("intake_in"));
  }

  public void out() {
    move(-RobotMap.values.get("intake_out"));
  }

  public void stop() {
    move(0.0);
  }

  public void brakeMode(boolean state) {
    RobotMap.intake.enableBrakeMode(state);
  }
}
