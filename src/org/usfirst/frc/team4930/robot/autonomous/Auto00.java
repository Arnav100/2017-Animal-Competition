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

    // AUTO TESTS:

    // forward at 1/2 speed for 2 seconds, die after 4 seconds
    addSequential(new GoStraightDR(0.5, 2), 4);

    // forward at 1/2 speed for 40 inches, die after 4 seconds
    // addSequential(new GoStraightBB(0.5, 40), 4);

    // spin 90* clockwise, die after 4 seconds
    // addSequential(new GoToHeadingBB(0.5, 90), 4);

    // left turn until 90* at 1/2 speed, die after 4 seconds
    // addSequential(new MoveLeftSideBB(0.5, 90), 4);

    // right turn until 90* at 1/2 speed, die after 4 seconds
    // addSequential(new MoveRightSideBB(0.5, 90), 4);

  }
}
