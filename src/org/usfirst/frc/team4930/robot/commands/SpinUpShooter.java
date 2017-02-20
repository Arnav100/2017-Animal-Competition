package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpinUpShooter extends Command
{

  public SpinUpShooter() {
    requires(Robot.shooter);
  }

  protected void initialize() {}

  protected void execute() {
    Robot.shooter.spinUp(0.9);
    Timer.delay(1);
  }

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.shooter.stop();
  }

  protected void interrupted() {
    end();
  }
}
