package org.usfirst.frc.team4930.robot.commands;

import java.io.FileNotFoundException;
import org.usfirst.frc.team4930.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ReplayPlayback extends Command
{

  protected void initialize() {
    try {
      Robot.replayPlayer.setup();
      System.out.println("Replay Init");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  protected void execute() {
    System.out.println("Replay Exec");
    Robot.replayPlayer.play();
  }

  protected boolean isFinished() {
    return !Robot.isReplaying;
  }

  protected void end() {
    System.out.println("Replay Finished");
    Robot.replayPlayer.end();
  }

  protected void interrupted() {
    end();
  }
}
