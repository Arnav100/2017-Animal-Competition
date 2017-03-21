package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.PlaceGear;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Autonomous: Drive Straight Across Line
 */
public class Auto01 extends CommandGroup
{
  public Auto01() {
    System.out.println("AUTO 1: Drive Across Line");
    addSequential(new MoveBB(-0.7, 110));
    addSequential(new TurnRightBB(-0.7, 49));
    addSequential(new Timer(0.5));
    addSequential(new PlaceGear());
    addSequential(new MoveBB(0.3, 12));
  }
}
