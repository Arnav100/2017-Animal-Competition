package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Spin using a gyroscope (bang bang control)
 * 
 * @todo
 */
public class SpinRightBB extends Command
{
  public double speed;
  public int degree;

  public SpinRightBB(double s, int d) {
    this.speed = s;
    this.degree = d;
    requires(Robot.driveTrain);
  }

  protected void initialize() {
    Robot.gyro.setStart();
  }

  protected void execute() {
    Robot.driveTrain.move(speed, -speed);
  }

  protected boolean isFinished() {
    return !(Robot.gyro.getAngle() < degree + Robot.gyro.getStart());
  }

  protected void end() {
    Robot.driveTrain.stop();
  }

  protected void interrupted() {
    end();
  }
}
