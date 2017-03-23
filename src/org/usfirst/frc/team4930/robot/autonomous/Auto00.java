package org.usfirst.frc.team4930.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Auto Dial (00): Do nothing.
 * Red/Blue: Ignored.
 * ReplayCode: Ignored.
 *
 *              [?]
 *     _____________________
 */
public class Auto00 extends CommandGroup
{
  public Auto00() {
    System.out.println("AUTO 00: Do Nothing");
    addSequential(new GoStraightDR(0.5, 2), 4);
    addSequential(new GoStraightBB(0.5, 40), 4);
    addSequential(new MoveLeftSideBB(0.5, 90), 4);
    addSequential(new MoveRightSideBB(0.5, 90), 4);
  }
}
