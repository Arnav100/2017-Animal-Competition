package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Turn left using a gyroscope (bang bang control)
 */
public class MoveLeftSideBB extends Command
{
  public double speed;
  public int degrees;
  public int heading;
  public int offset = 2; // degrees

  public MoveLeftSideBB(double s, int d) {
    this.speed = s;
    this.degrees = d;
    requires(Robot.driveTrain);
  }

  protected void initialize() {
    if (speed > 0) {
      heading = Robot.gyro.getAngle() + degrees - offset;
    } else {
      heading = Robot.gyro.getAngle() - degrees + offset;
    }
  }

  protected void execute() {
    Robot.driveTrain.move(speed, speed / 3);
  }

  protected boolean isFinished() {
    int angle = Robot.gyro.getAngle();
    if (speed > 0) {
      if (angle < heading) {
        return false;
      } else {
        return true;
      }
    } else {
      if (angle > heading) {
        return false;
      } else {
        return true;
      }
    }
  }

  protected void end() {}

  protected void interrupted() {
    end();
  }
}
