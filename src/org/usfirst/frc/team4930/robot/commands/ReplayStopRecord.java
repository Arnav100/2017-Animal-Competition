package org.usfirst.frc.team4930.robot.commands;

import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ReplayStopRecord extends Command
{
  protected void initialize() {
    if (Robot.oi.j2b7.get()) {
      Robot.isRecording = false;
    }
  }

  protected void execute() {}

  protected boolean isFinished() {
    return true;
  }

  protected void end() {}

  protected void interrupted() {
    end();
  }
}
