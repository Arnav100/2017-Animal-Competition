package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Move using encoders (bang bang control)
 */
public class MoveBB extends Command
{
  public double speed;
  public double inches;

  public MoveBB(double s, double i) {
    this.speed = s;
    this.inches = i;
    requires(Robot.motor);
  }

  protected void initialize() {
    // Robot.encoders.reset();
  }

  protected void execute() {
    Robot.motor.move(this.speed);
  }

  protected boolean isFinished() {
    // if (Robot.encoders.posInches() < this.inches) {
    // return false;
    // } else {
    // return true;
    // }
    return false;
  }

  protected void end() {
    Robot.motor.stop();
  }

  protected void interrupted() {
    end();
  }
}
