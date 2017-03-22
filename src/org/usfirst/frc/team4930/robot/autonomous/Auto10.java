package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.ReplayPlayback;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous 10: Only plays back #10 replay code.
 */
public class Auto10 extends CommandGroup
{
  public Auto10() {
    System.out.println("REPLAY 10: Initializing");
    addSequential(new ReplayPlayback());
  }
}
