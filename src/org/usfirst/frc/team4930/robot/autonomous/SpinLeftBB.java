package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Spin using a gyroscope (bang bang control)
 * 
 * @todo
 */
public class SpinLeftBB extends Command
{
  public int degree;
  public double speed;

  public SpinLeftBB(int d, double s) {
    this.degree = d;
    this.speed = s;
    requires(Robot.driveTrain);
  }

  protected void initialize() {
    Robot.gyro.calibrating();
  }

  protected void execute() {
    if (degree < 180)
      Robot.driveTrain.move(this.speed, -this.speed);
    else
      Robot.driveTrain.move(-this.speed, this.speed);
  }

  protected boolean isFinished() {
    if (Robot.gyro.getAngle() < degree) {
      return false;
    } else {
      return true;
    }
  }

  protected void end() {
    Robot.driveTrain.stop();
  }

  protected void interrupted() {
    end();
  }
}
