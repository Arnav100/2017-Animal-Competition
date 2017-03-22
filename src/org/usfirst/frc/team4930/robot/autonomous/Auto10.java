package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.ReplayPlayback;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Auto Dial (10r): Always runs ReplayCode.
 * Red/Blue: Determines direction of ReplayCode.
 * ReplayCode: Ignored. Always run ReplayCode.
 *
 *              [?]
 *   b _____________________ r
 */
public class Auto10 extends CommandGroup
{
  public Auto10() {
    System.out.println("REPLAY 10: Initializing");
    addSequential(new ReplayPlayback());
  }
}
