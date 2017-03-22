package org.usfirst.frc.team4930.robot.autonomous;

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
    addSequential(new MoveLeftSideBB(0.7, 30));
    addSequential(new ShootFuel());
  }
}
