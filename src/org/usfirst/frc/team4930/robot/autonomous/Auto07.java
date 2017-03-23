package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.commands.*;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Auto Dial (07): Go to hopper, intake, then shoot.
 * Red/Blue: Determines direction.
 * ReplayCode: Ignored.
 *
 *     h                   h
 *   i |\                 /| i
 *     | \               / |
 *     |  \             /  |
 *     s  [v]         [v]  s
 *   b _____________________ r
 */
public class Auto07 extends CommandGroup
{
  public Auto07() {

    // Not Complete

    System.out.println("AUTO 07: Initializing");

    addSequential(new GoStraightBB(-0.75, 100), 5);

    if (Robot.isRed) {
      addSequential(new GoToHeadingBB(-0.7, -50), 2);
      addSequential(new GoToHeadingBB(-0.7, -45), 2);
    } else {
      addSequential(new GoToHeadingBB(-0.7, 50), 2);
      addSequential(new GoToHeadingBB(-0.7, 45), 2);
    }

    addParallel(new IntakeFuel(), 4);
    addParallel(new GoStraightBB(0.75, 100), 5);

    if (Robot.isRed) {
      addSequential(new MoveRightSideBB(-0.7, 49));
    } else {
      addSequential(new MoveLeftSideBB(-0.7, 49));
    }

  }
}
