package org.usfirst.frc.team4930.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Auto Dial (07): Go to hopper, intake, then shoot.
 * Red/Blue: Determines direction.
 * ReplayCode: Ignored.
 *
 *     h                   h
 *   i |\                 /| i
 *     |  \             /  |
 *     |    \         /    |
 *     s     [v]   [v]     s
 *   b _____________________ r
 */
public class Auto07 extends CommandGroup
{
  public Auto07() {
    System.out.println("AUTO 07: Initializing");
  }
}
