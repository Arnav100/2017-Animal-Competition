package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Auto Dial (05r): Intake fuel dropped from alliance parters then shoot.
 * Red/Blue: Determines direction of ReplayCode.
 * ReplayCode: Run ReplayCode if ON.
 *
 *             i
 *          [>]----------->s
 *     _____________________ r
 *
 *                 i
 *     s<-----------[<]
 *   b _____________________
 */
public class Auto05 extends CommandGroup
{
  public Auto05() {

    System.out.println("AUTO 05: Initializing");

    addParallel(new GoStraightBB(0.7, 81));
    addParallel(new IntakeFuel(), 4);

    if (!Robot.isRed) {
      addSequential(new MoveLeftSideBB(0.7, 45));
      addSequential(new MoveRightSideBB(0.7, 90));
    } else {
      addSequential(new MoveRightSideBB(0.7, 45));
      addSequential(new MoveLeftSideBB(0.7, 90));
    }

    addParallel(new ShootFuel(), 5);
    addParallel(new LoadShooter(), 5);
    addParallel(new AgitateFuel(), 5);
    addSequential(new Timer(5.0));

    if (Robot.isReplayOn) {
      addSequential(new ReplayPlayback());
    }

  }
}
