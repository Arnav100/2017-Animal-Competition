package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Turn right using a gyroscope (bang bang control)
 */
public class MoveRightSideBB extends Command
{
  public double speed;
  public int degrees;
  public int heading;
  public int offset = 2; // degrees

  public MoveRightSideBB(double s, int d) {
    this.speed = s;
    this.degrees = d;
    requires(Robot.driveTrain);
  }

  protected void initialize() {
    if (speed > 0) {
      heading = Robot.gyro.getAngle() - degrees + offset;
    } else {
      heading = Robot.gyro.getAngle() + degrees - offset;
    }
  }

  protected void execute() {
    Robot.driveTrain.auto((speed / 3), speed);
  }

  protected boolean isFinished() {
    int angle = Robot.gyro.getAngle();
    if (speed > 0) {
      if (angle > heading) {
        return false;
      } else {
        return true;
      }
    } else {
      if (angle < heading) {
        return false;
      } else {
        return true;
      }
    }
  }

  protected void end() {
    Robot.driveTrain.stop();
  }

  protected void interrupted() {
    end();
  }
}
