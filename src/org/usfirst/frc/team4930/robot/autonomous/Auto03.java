package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto03 extends CommandGroup
{
  public Auto03() {

    System.out.println("REPLAY 03: Initializing");

    addSequential(new ReplayPlayback());

  }
}
