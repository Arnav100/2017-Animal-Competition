package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Go to a particular heading using a gyroscope (bang bang control)
 */
public class GoToHeadingBB extends Command
{
  public double speed;
  public int heading;
  public int offset = 1; // degrees

  public GoToHeadingBB(double s, int h) {
    speed = s;
    heading = h;
    requires(Robot.driveTrain);
  }

  protected void initialize() {}

  protected void execute() {
    if (heading < Robot.gyro.getAngle()) {
      Robot.driveTrain.move(-speed, speed);
    } else {
      Robot.driveTrain.move(speed, -speed);
    }
  }

  protected boolean isFinished() {
    int angle = Robot.gyro.getAngle();
    if (angle <= (heading + offset) && angle >= (heading - offset)) {
      return true;
    } else {
      return false;
    }
  }

  protected void end() {
    Robot.driveTrain.stop();
  }

  protected void interrupted() {
    end();
  }
}
