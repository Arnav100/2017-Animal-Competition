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
    requires(Robot.driveTrain);
  }

  protected void initialize() {
    Robot.encoders.reset();
  }

  protected void execute() {
    Robot.driveTrain.move(this.speed, this.speed);
  }

  protected boolean isFinished() {
    if (Robot.encoders.leftPosInches() < this.inches) {
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
