package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Auto Dial (09r): Place gear in the middle while unloading fuel for others.
 * Red/Blue: Determines direction of ReplayCode.
 * ReplayCode: Run ReplayCode if ON.
 *
 *               g
 *               | u
 *               |
 *              [v]
 *   b _____________________ r
 */
public class Auto09 extends CommandGroup
{
  public Auto09() {

    System.out.println("AUTO 09: Initializing");

    addParallel(new UnloadHopper(), 4);
    addSequential(new GoStraightBB(-0.75, 30), 4);
    addSequential(new GoStraightBB(-0.4, 10), 2);
    addSequential(new PlaceGear());
    addParallel(new GoStraightBB(0.4, 10), 2);
    addParallel(new PlaceGear());
    addSequential(new Timer(0.3));

    if (Robot.isReplayOn) {
      addSequential(new ReplayPlayback());
    }

  }
}
