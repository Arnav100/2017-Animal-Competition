package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.commands.ReplayPlayback;
import edu.wpi.first.wpilibj.command.*;

public class AutoReplay extends Command
{
  public AutoReplay() {
    requires(Robot.motor);
  }

  protected void initialize() {
    System.out.println("AUTO: Initializing AutoReplay()");
    new ReplayPlayback();
  }

  protected void execute() {}

  protected boolean isFinished() {
    return false;
  }

  protected void end() {
    Robot.motor.stop();
  }

  protected void interrupted() {
    end();
  }
}
