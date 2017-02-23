package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Climber extends Subsystem
{
  public void initDefaultCommand() {}

  public void climb(double output) {
    RobotMap.climber.set(-output);
  }

  public void stop() {
    RobotMap.climber.set(0.0);
  }

  public double getClimber() {
    return -RobotMap.climber.get();
  }

  public void brakeMode(boolean state) {
    RobotMap.climber.enableBrakeMode(state);
  }
}
