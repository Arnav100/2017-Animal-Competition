
package org.usfirst.frc.team4930.sensors;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;

public class Gyro
{
  private final ADXRS450_Gyro gyro = RobotMap.gyro;
  private boolean isRunning;
  double start = 0;

  public double getAngle() {
    return gyro.getAngle();

  }

  public void setStart() {
    start = gyro.getAngle();
  }

  public void turn(double degree, double speed, boolean isRight) {
    isRunning = true;
    if (isRight) {

      if (gyro.getAngle() <= degree + start) {
        Robot.driveTrain.move(0.0, -speed);
      } else {
        isRunning = false;
      }
    }

    else {
      if (gyro.getAngle() <= degree + start) {
        Robot.driveTrain.move(speed, 0.0);
      } else {
        isRunning = false;
      }
    }
  }

  public void spin(double degree, double speed, boolean isClockwise) {
    isRunning = true;

    if (isClockwise) {
      if (gyro.getAngle() <= degree + start) {
        Robot.driveTrain.move(speed, -speed);
      } else {
        isRunning = false;
      }
    } else {
      if (gyro.getAngle() >= -degree + start) {
        Robot.driveTrain.move(-speed, speed);
      }

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
