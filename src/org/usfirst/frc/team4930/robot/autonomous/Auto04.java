package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous 04: Place gear on right side.
 * 
 *         g 
 *          \ 
 *           |
 *           | 
 *          []
 *  ___________
 */
public class Auto04 extends CommandGroup
{
  public Auto04() {
    System.out.println("AUTO 04: Initializing");
    addSequential(new GoStraightBB(-0.7, 66));
    addSequential(new Timer(0.5));
    addSequential(new PlaceGear());
    addSequential(new GoStraightBB(0.3, 12));
  }
}
