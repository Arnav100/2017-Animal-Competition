package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.ReplayPlayback;
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
    System.out.println("REPLAY 09: Initializing");
    addSequential(new ReplayPlayback());
  }
}
