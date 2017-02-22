package org.usfirst.frc.team4930.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddleGear extends CommandGroup
{
  public MiddleGear() {
    addSequential(new MiddleReplay());
  }

}
