package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto04 extends CommandGroup
{
  public Auto04() {

    System.out.println("REPLAY 04: Initializing");

    addSequential(new ReplayPlayback());

  }
}
