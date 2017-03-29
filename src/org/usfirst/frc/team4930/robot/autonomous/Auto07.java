package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto07 extends CommandGroup
{
  public Auto07() {

    System.out.println("REPLAY 07: Initializing");

    addSequential(new ReplayPlayback());

  }
}
