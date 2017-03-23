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

    System.out.println("AUTO 02: Initializing");

    addSequential(new GoStraightBB(-0.75, 40), 4);
    addSequential(new MoveRightSideBB(-0.75, 45), 3);
    addSequential(new GoStraightBB(-0.4, 10), 2);
    addSequential(new PlaceGear());
    addParallel(new GoStraightBB(0.4, 10), 2);
    addParallel(new PlaceGear());
    addSequential(new Timer(0.3));

    if (!Robot.isRed && Robot.isReplayOn) {
      addSequential(new ReplayPlayback());
    }

  }
}
