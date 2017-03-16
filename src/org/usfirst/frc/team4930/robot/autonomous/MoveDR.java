package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Move using speed and time (dead reckoning)
 */
public class MoveDR extends Command
{
  public double speed;
  public double seconds;

  public MoveDR(double speed, double seconds) {
    this.speed = speed;
    this.seconds = seconds;
    requires(Robot.motor);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.motor.move(speed);
  }

  protected boolean isFinished() {
    return seconds < timeSinceInitialized();
  }

  protected void end() {
    Robot.motor.stop();
  }

  protected void interrupted() {
    end();
  }
}
