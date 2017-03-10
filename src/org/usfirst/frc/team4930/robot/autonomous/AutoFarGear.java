package org.usfirst.frc.team4930.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoFarGear extends CommandGroup
{
  public AutoFarGear() {
    addSequential(new Timer(0.5));
    addSequential(new AutoReplay());
  }
}
