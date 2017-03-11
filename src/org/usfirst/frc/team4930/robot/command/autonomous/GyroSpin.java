package org.usfirst.frc.team4930.robot.command.autonomous;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GyroSpin extends Command
{
  protected double degree;
  protected double speed;
  protected boolean isClockwise;

  public GyroSpin(double newDegree, double newSpeed, boolean newIsClockwise) {

    degree = newDegree;
    speed = newSpeed;
    isClockwise = newIsClockwise;
  }

  protected void initialize() {
    Robot.gyro.setStart();
  }

  protected void execute() {
    Robot.gyro.spin(degree, speed, isClockwise);
  }

  protected boolean isFinished() {

    return !Robot.gyro.getRunning();
  }

  protected void end() {
    Robot.gyro.stop();
  }

  protected void interrupted() {
    end();
  }
}
