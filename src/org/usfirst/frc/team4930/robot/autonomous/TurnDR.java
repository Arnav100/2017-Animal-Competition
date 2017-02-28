package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Turn using speed and time (dead reckoning)
 */
public class TurnDR extends Command
{

  public TurnDR() {}

  protected void initialize() {}

  protected void execute() {
    // attempt to smooth transition
    double left = Robot.driveTrain.leftSide;
    double right = Robot.driveTrain.rightSide;
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {}

  protected void interrupted() {
    end();
  }
}
