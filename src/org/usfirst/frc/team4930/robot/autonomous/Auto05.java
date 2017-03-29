package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto05 extends CommandGroup
{
  public Auto05() {

    System.out.println("REPLAY 05: Initializing");

    addSequential(new ReplayPlayback());

  }
}
