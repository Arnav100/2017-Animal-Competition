package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Turn left using a gyroscope (bang bang control)
 */
public class MoveLeftSideDR extends Command
{
  public double speed;
  public double seconds;

  public MoveLeftSideDR(double s, double sec) {
    this.speed = s;
    this.seconds = sec;
    requires(Robot.driveTrain);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.driveTrain.auto(speed, 0.0);
  }

  protected boolean isFinished() {
    return seconds <= timeSinceInitialized();
  }

  protected void end() {
    Robot.driveTrain.stop();
  }

  protected void interrupted() {
    end();
  }
}
