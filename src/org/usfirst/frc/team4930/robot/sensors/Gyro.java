package org.usfirst.frc.team4930.robot.sensors;

import org.usfirst.frc.team4930.robot.RobotMap;

public class Gyro
{

  public Gyro() {
    calibrate();
  }

  public void calibrate() {
    RobotMap.gyro.calibrate();
    reset();
  }

  public void reset() {
    RobotMap.gyro.reset();
  }

  public double heading() {
    return RobotMap.gyro.getAngle();
  }
}
