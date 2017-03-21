package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.PlaceGear;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous 03: Place gear in the middle.
 * 
 * 
 *       g 
 *       |
 *       | 
 *      []
 *  ___________
 */
public class Auto03 extends CommandGroup
{
  public Auto03() {
    System.out.println("AUTO 03: Initializing");
    addSequential(new GoStraightBB(-0.7, 110));
    addSequential(new MoveLeftSideBB(-0.7, 49));
    addSequential(new Timer(0.5));
    addSequential(new PlaceGear());
    addSequential(new GoStraightBB(0.3, 12));
  }
}
