package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Spin extends Command
{
  public double speed;
  public int degree;
  public boolean direction;

  public Spin(double s, int d) {
    this.speed = s;
    this.degree = d;
    requires(Robot.driveTrain);
  }

  protected void initialize() {
    Robot.gyro.setStart();
  }

  protected void execute() {
    if (this.degree > 0) {
      Robot.driveTrain.move(speed, -speed);
      direction = !(Robot.gyro.getAngle() < degree + Robot.gyro.getStart());
    } else {
      Robot.driveTrain.move(-speed, speed);
      direction = !(Robot.gyro.getAngle() > degree + Robot.gyro.getStart());
    }
  }

  protected boolean isFinished() {
    return direction;
  }

  protected void end() {
    Robot.driveTrain.stop();
  }

  protected void interrupted() {
    end();
  }
}
