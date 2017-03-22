package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.commands.PlaceGear;
import org.usfirst.frc.team4930.robot.commands.ReplayPlayback;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Auto Dial (03r): Place gear in the middle.
 * Red/Blue: Determines direction of ReplayCode.
 * ReplayCode: Run ReplayCode if ON.
 *
 *               g
 *               |
 *               |
 *              [v]
 *   b _____________________ r
 */
public class Auto03 extends CommandGroup
{
  public Auto03() {
    if (Robot.isReplaySet) {
      System.out.println("REPLAY 03: Initializing");
      addSequential(new ReplayPlayback());
    } else {
      System.out.println("AUTO 03: Initializing");
      addSequential(new GoStraightBB(-0.7, 110));
      addSequential(new MoveLeftSideBB(-0.7, 49));
      addSequential(new Timer(0.5));
      addSequential(new PlaceGear());
      addSequential(new GoStraightBB(0.3, 12));
    }
  }
}
