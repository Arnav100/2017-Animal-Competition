package org.usfirst.frc.team4930.robot.command.autonomous;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class EncoderMove extends Command
{

  private double speed;
  private double feet;

  public EncoderMove(double newSpeed, double newFeet) {
    speed = newSpeed;
    feet = newFeet;
  }

  protected void initialize() {
    Robot.encoder.reset();
  }

  protected void execute() {
    Robot.encoder.move(speed, feet);
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
