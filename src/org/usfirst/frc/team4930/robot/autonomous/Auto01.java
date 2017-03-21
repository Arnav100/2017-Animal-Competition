package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous 01: Drive Straight Across Line
 * 
 *          ^
 *          |
 *          |
 *          | 
 *         []
 *  ___________
 */
public class Auto01 extends CommandGroup
{
  public Auto01() {
    System.out.println("AUTO 01: Initializing");
    addSequential(new GoStraightBB(-0.7, 110));
    addSequential(new MoveRightSideBB(-0.7, 49));
    addSequential(new Timer(0.5));
    addSequential(new PlaceGear());
    addSequential(new GoStraightBB(0.3, 12));
  }
}
