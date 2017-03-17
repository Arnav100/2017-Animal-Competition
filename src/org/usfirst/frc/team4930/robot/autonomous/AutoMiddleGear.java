package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoMiddleGear extends CommandGroup
{
  public AutoMiddleGear() {
    System.out.println("AUTO: Initializing AutoMiddleGear()");
    addSequential(new MoveBB(-0.4, 12));
    addSequential(new Timer(1.5));
    addSequential(new PlaceGear());
    addSequential(new Timer(1.5));
    addSequential(new ReplayPlayback());
  }
}
