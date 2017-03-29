package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto02 extends CommandGroup
{
  public Auto02() {

    System.out.println("REPLAY 02: Initializing");

    addSequential(new ReplayPlayback());

  }
}
