package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous 05: Intake (i) fuel along window and shoot (s).
 * 
 *         i
 *     []----->s
 * ______________ red
 * 
 *      i
 *  s<-----[]
 * ______________ blue
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
