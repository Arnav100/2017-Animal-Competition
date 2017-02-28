package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoMiddleGear extends CommandGroup
{
  public AutoMiddleGear() {
    addSequential(new MoveDR(0.5, 3.0));
    addSequential(new PlaceGear());
    addSequential(new Timer(0.5));
    addSequential(new AutoReplay());
  }
}
