package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Auto Dial (02r): Place gear on left side.
 * Red/Blue: Red Ignored. Blue Accepted.
 * ReplayCode: Run ReplayCode if ON and Blue selected.
 *
 *           g
 *          /
 *         |
 *         |
 *        [v]
 *   b _____________________
 */
public class Auto02 extends CommandGroup
{
  public Auto02() {

    // if !isRed and isReplaySet then run ReplayCode

    if (Robot.isReplayOn) {
      System.out.println("REPLAY 02: Initializing");
      addSequential(new ReplayPlayback());
    } else {
      System.out.println("AUTO 02: Initializing");
      addSequential(new GoStraightBB(-0.7, 66));
      addSequential(new Timer(0.5));
      addSequential(new PlaceGear());
      addSequential(new GoStraightBB(0.3, 12));
    }

    if (Robot.isReplayOn) {
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
