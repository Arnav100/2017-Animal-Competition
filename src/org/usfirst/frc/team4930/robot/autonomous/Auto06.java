package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto06 extends CommandGroup
{
  public Auto06() {

    System.out.println("REPLAY 06: Initializing");

    addSequential(new ReplayPlayback());

  }
}
