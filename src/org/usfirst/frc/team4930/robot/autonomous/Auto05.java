package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous 05: Pick up fuel along window and shoot.
 * 
 * 
 *       I
 *   []----->s
 * ___________ red
 * 
 * 
 *      I
 *  s<-----[]
 * ___________ blue
 * 
 */
public class Auto05 extends CommandGroup
{
  public Auto05() {
    System.out.println("AUTO 05: Initializing");
    addParallel(new GoStraightBB(0.7, 81));
    addParallel(new IntakeFuel(), 4);
    addSequential(new MoveLeftSideBB(0.7, 30));
    addSequential(new ShootFuel());
  }
}
