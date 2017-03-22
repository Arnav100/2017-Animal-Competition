package org.usfirst.frc.team4930.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Auto Dial (06r): Drive short and shoot.
 * Red/Blue: Determines direction of ReplayCode.
 * ReplayCode: Run ReplayCode if ON.
 *
 *     s<-[<]         [>]->s
 *   b _____________________ r
 */
public class Auto06 extends CommandGroup
{
  public Auto06() {
    System.out.println("AUTO 06: Initializing");
  }
}
