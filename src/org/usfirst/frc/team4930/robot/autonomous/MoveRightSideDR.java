package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Turn right using a gyroscope (bang bang control)
 */
public class MoveRightSideDR extends Command
{
  public double speed;
  public double seconds;

  public MoveRightSideDR(double s, double sec) {
    this.speed = s;
    this.seconds = sec;
    requires(Robot.driveTrain);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.driveTrain.auto(0.0, speed);
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
