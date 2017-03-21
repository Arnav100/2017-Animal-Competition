package org.usfirst.frc.team4930.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto007 extends CommandGroup
{
  public Auto007() {
    System.out.println("AUTO: Initializing DriveAcrossLine()");
    addSequential(new MoveBB(1.0, 120));
  }
}
