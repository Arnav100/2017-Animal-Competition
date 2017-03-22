package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.ReplayPlayback;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous 08: Trigger hopper (h) short intake (i) and shoot (s).
 * 
 *      h__         __h
 *    i |  |       |  | i
 *      |  |       |  |
 *      s [v]     [v] s
 * blue _______________ red
 * 
 */
public class Auto08 extends CommandGroup
{
  public Auto08() {
    System.out.println("REPLAY 08: Initializing");
    addSequential(new ReplayPlayback());
  }
}
