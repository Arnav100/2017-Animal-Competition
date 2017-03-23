package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Auto Dial (04r): Place gear on right side.
 * Red/Blue: Red Accepted. Blue Ignored.
 * ReplayCode: Run ReplayCode if ON and Red selected.
 *
 *                   g
 *                    \
 *                     |
 *                     |
 *                    [v]
 *     _____________________ r
 */
public class Auto04 extends CommandGroup
{
  public Auto04() {

    System.out.println("AUTO 04: Initializing");

    addSequential(new GoStraightBB(-0.75, 40), 4);
    addSequential(new MoveLeftSideBB(-0.75, 45), 3);
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
