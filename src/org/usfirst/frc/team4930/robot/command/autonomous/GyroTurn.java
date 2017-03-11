package org.usfirst.frc.team4930.robot.command.autonomous;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GyroTurn extends Command
{
  private double degree;
  private double speed;
  private boolean isRight;

  public GyroTurn(double newDegree, double newSpeed, boolean newIsRight) {
    degree = newDegree;
    speed = newSpeed;
    isRight = newIsRight;

  }

  protected void initialize() {
    Robot.gyro.setStart();
  }

  protected void execute() {
    Robot.gyro.turn(degree, speed, isRight);
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
