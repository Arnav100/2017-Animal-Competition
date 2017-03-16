package org.usfirst.frc.team4930.robot.sensors;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Gyro
{
  private final ADXRS450_Gyro gyro = RobotMap.gyro;

  public Integer getAngle() {
    return null;
    // return (int) gyro.getAngle();

  }

  public void calibrating() {
    // gyro.calibrate();
  }

}
