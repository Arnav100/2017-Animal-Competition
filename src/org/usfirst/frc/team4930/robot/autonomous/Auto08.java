package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.ReplayPlayback;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous 08: Only plays back replay code.
 */
public class Auto08 extends CommandGroup
{
  public Auto08() {
    System.out.println("REPLAY 08: Initializing");
    addSequential(new ReplayPlayback());
  }
}
