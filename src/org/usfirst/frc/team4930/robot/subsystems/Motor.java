package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Motor extends Subsystem
{
  public void initDefaultCommand() {}

  public void move(double value) {
    RobotMap.motor.set(-value);
  }

  public void rotate() {
    move(RobotMap.values.get("motors"));
  }

  public void stop() {
    move(0.0);
  }

  public void brakeMode(boolean state) {
    RobotMap.motor.enableBrakeMode(state);
  }
}
