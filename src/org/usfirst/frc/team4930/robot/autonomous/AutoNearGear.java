package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.ReplayPlayback;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoNearGear extends CommandGroup
{
  public AutoNearGear() {
    System.out.println("AUTO: Initializing AutoNearGear()");
    addSequential(new ReplayPlayback());
  }
}
