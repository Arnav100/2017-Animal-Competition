package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.ReplayPlayback;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous 09: Place gear (g) in the middle while unloading (u) fuel.
 * 
 *       g 
 *       | u
 *       | 
 *      []
 *  ___________
 *  
 */
public class Auto09 extends CommandGroup
{
  public Auto09() {
    System.out.println("REPLAY 09: Initializing");
    addSequential(new ReplayPlayback());
  }
}
