package org.usfirst.frc.team4930.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto01 extends CommandGroup
{
  public Auto01() {

    System.out.println("AUTO 01: Initializing");

    addSequential(new GoStraightDR(0.9, 2), 3);

  }
}
