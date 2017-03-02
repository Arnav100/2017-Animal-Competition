package org.usfirst.frc.team4930.robot.command.autonomous;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class GyroTurn extends Command
{
  private double degree;

  public GyroTurn(double newDegree) {
    degree = newDegree;

  }

  protected void initialize() {
    Robot.gyro.setStart();
  }

  protected void execute() {
    Robot.gyro.turn(degree);
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
