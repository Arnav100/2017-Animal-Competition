package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.*;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Move using encoders (bang bang control)
 */
public class GoStraightBB extends Command
{
  public double speed;
  public double inches;

  public GoStraightBB(double s, double i) {
    this.speed = s;
    this.inches = i;
    requires(Robot.driveTrain);
  }

  protected void initialize() {
    Robot.encoders.reset();
  }

  protected void execute() {
    Robot.driveTrain.move(-speed, -speed);
  }

  protected boolean isFinished() {
    // get position in inches
    double i = Robot.encoders.leftPosInches();
    // approximate backlash formula
    double b = 1 + (10 * speed);
    // calculate i based on backlash formula
    if (i > 1) {
      i = i - b;
    }
    if (i < 1) {
      i = i + b;
    }
    // check if greater or less than the absolute value
    if (i > inches || i < -inches) {
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
