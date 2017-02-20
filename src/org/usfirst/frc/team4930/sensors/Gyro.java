
package org.usfirst.frc.team4930.sensors;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Gyro
{
  private final ADXRS450_Gyro gyro = RobotMap.gyro;
  private boolean isRunning;

  public double getAngle() {
    return gyro.getAngle();

  }

  public void turn(double degree) {
    isRunning = true;

    if (gyro.getAngle() <= degree) {
      Robot.driveTrain.move(0.0, -0.3);
    } else {
      isRunning = false;
    }

  }

  public void calibrating() {
    gyro.calibrate();
  }

  public void stop() {
    Robot.driveTrain.stop();
  }

  public boolean getRunning() {
    return isRunning;
  }
}
