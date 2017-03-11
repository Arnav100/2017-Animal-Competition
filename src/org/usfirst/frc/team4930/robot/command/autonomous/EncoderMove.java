package org.usfirst.frc.team4930.robot.command.autonomous;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderMove extends Command
{

  private double speed;
  private double inches;

  public EncoderMove(double newSpeed, double newInches) {
    speed = newSpeed;
    inches = newInches;
  }

  protected void initialize() {
    Robot.encoder.reset();
    Robot.encoder.setStart();
  }

  protected void execute() {
    Robot.encoder.move(speed, inches);
  }

  protected boolean isFinished() {
    return !Robot.encoder.getRunning();
  }

  protected void end() {
    Robot.encoder.stop();
  }

  protected void interrupted() {
    end();
  }
}
