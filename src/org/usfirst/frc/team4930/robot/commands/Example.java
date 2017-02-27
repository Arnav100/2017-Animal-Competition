package org.usfirst.frc.team4930.robot.commands;

// commands should never import RobotMap!
import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class Example extends Command
{
  public Example() {
    // use requires() here to declare subsystem dependencies. Example...
    requires(Robot.shooter);
  }

  // called just once before this Command runs for the first time
  protected void initialize() {}

  // called repeatedly when this Command is scheduled to run
  protected void execute() {}

  // make this function return true when this Command no longer needs to run execute()
  protected boolean isFinished() {
    return false;
  }

  // called once after isFinished returns true
  protected void end() {}

  // called when another command which requires one or more of the same required subsystems
  protected void interrupted() {
    // optionally call end when the command is interrupted
    end();
  }
}
