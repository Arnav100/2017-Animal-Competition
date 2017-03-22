package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous 01: Drive Straight Across Line
 * 
 *          ^
 *          |
 *          |
 *          | 
 *         []
 *  _____________
 *  
 */
public class Auto01 extends CommandGroup
{
  public Auto01() {
    if (Robot.isReplaySet) {
      System.out.println("REPLAY 01: Initializing");
      addSequential(new ReplayPlayback());
    } else {
      System.out.println("AUTO 01: Initializing");
      addSequential(new GoStraightBB(-0.7, 110));
      if (Robot.isRed) {
        addSequential(new MoveRightSideBB(-0.7, 49));
      } else {
        addSequential(new MoveLeftSideBB(-0.7, 49));
      }
      addSequential(new Timer(0.5));
      addSequential(new PlaceGear());
      addSequential(new GoStraightBB(0.3, 12));
    }
  }
}
