package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.*;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Move using encoders (bang bang control)
 */
public class GoStraightBB extends Command
{
  public double speed;
  public double ticks;

  public GoStraightBB(double s, double t) {
    speed = s;
    ticks = t;
    requires(Robot.driveTrain);
  }

  protected void initialize() {
    Robot.encoders.reset();
  }

  protected void execute() {
    Robot.driveTrain.auto(speed, speed);
  }

  protected boolean isFinished() {
    double i = Robot.encoders.leftPosRaw();
    if (Math.abs(i) >= ticks) {
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
