package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.ReplayPlayback;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Auto Dial (08): Go to hopper, intake, then shoot.
 * Red/Blue: Determines direction.
 * ReplayCode: Ignored.
 *
 *     h___             ___h
 *   i |   |           |   | i
 *     |   |           |   |
 *     s  [^]         [^]  s
 *   b _____________________ r
 */
public class Auto08 extends CommandGroup
{
  public Auto08() {
    System.out.println("REPLAY 08: Initializing");
    addSequential(new ReplayPlayback());
  }
}
