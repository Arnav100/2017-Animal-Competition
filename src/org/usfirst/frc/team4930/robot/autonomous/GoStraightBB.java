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
  public double backlash = 2; // inches

  public GoStraightBB(double s, double i) {
    speed = s;
    inches = i;
    requires(Robot.driveTrain);
  }

  protected void initialize() {
    Robot.encoders.reset();
  }

  protected void execute() {
    Robot.driveTrain.move(speed, speed);
  }

  protected boolean isFinished() {
    double i = Robot.encoders.leftPosInches();
    if (Math.abs(i) >= (inches - backlash)) {
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
