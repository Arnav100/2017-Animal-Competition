package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Gyro
{
  private final ADXRS450_Gyro gyro = RobotMap.gyro;

  public double getAngle() {
    return gyro.getAngle();
  }

  public void calibrate() {
    gyro.calibrate();
  }
}
