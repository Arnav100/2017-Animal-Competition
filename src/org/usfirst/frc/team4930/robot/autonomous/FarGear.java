package org.usfirst.frc.team4930.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class FarGear extends CommandGroup
{
  public FarGear() {
    addSequential(new Replay());
  }
}
