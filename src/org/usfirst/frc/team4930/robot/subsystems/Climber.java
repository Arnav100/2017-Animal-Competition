package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem
{
  public void initDefaultCommand() {}

  public void move(double value) {
    RobotMap.climber.set(value);
  }

  public void climb() {
    move(RobotMap.values.get("climber"));
  }

  public void stop() {
    move(0.0);
  }

  public void brakeMode(boolean state) {
    RobotMap.climber.enableBrakeMode(state);
  }
}
