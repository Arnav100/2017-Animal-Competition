package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Move using a PID controller
 */
public class MovePID extends Command
{
  public double speed;
  public double inches;

  public MovePID(double s, double i) {
    speed = s;
    inches = i;
    requires(Robot.driveTrain);
  }

  protected void initialize() {}

  protected void execute() {}

  protected boolean isFinished() {
    return false;
  }

  protected void end() {}

  protected void interrupted() {
    end();
  }
}