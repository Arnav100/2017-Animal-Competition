package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Move using encoder values
 */
public class MoveEnc extends Command
{
  public double speed;
  public double inches;

  public MoveEnc(double s, double i) {
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
