package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Move using encoders (PID control)
 */
public class GoStraightPID extends Command
{

  public GoStraightPID() {
    requires(Robot.driveTrain);
  }

  protected void initialize() {
    Robot.encoders.reset();
  }

  protected void execute() {}

  protected boolean isFinished() {
    return false;
  }

  protected void end() {}

  protected void interrupted() {
    end();
  }
}
