package org.usfirst.frc.team4930.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoNearGear extends CommandGroup
{
  public AutoNearGear() {
    addSequential(new AutoReplay());
  }
}
