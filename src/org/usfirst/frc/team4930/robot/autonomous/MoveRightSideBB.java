package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Turn left using a gyroscope (bang bang control)
 */
public class MoveRightSideBB extends Command
{
  public double speed;
  public int degrees;

  public MoveRightSideBB(double s, int d) {
    this.speed = s;
    this.degrees = d;
    requires(Robot.driveTrain);
  }

  protected void initialize() {
    degrees = (int) (Robot.gyro.getAngle() + degrees - (18 * speed));
  }

  protected void execute() {
    Robot.driveTrain.move(speed / 2, -speed);
  }

  protected boolean isFinished() {
    int angle = Robot.gyro.getAngle();
    if (angle > degrees || angle < -degrees) {
      return true;
    } else {
      return false;
    }
  }

  protected void end() {}

  protected void interrupted() {
    end();
  }
}
