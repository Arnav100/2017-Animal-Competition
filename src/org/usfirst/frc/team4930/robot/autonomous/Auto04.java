package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous 04r: Place gear (g) on right side.
 * 
 *         g 
 *          \ 
 *           |
 *           | 
 *          [v]
 *  ___________
 *  
 */
public class Auto04 extends CommandGroup
{
  public Auto04() {

    // if isRed and isReplaySet then run ReplayCode

    System.out.println("AUTO 04: Initializing");
    addSequential(new GoStraightBB(-0.7, 66));
    addSequential(new Timer(0.5));
    addSequential(new PlaceGear());
    addSequential(new GoStraightBB(0.3, 12));
  }
}
