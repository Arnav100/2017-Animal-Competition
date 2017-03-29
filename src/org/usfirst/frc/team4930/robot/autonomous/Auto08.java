package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto08 extends CommandGroup
{
  public Auto08() {

    System.out.println("REPLAY 08: Initializing");

    addSequential(new ReplayPlayback());

  }
}
