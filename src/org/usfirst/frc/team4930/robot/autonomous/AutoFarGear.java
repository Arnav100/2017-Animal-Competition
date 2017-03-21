package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.PlaceGear;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoFarGear extends CommandGroup
{
  public AutoFarGear() {
    System.out.println("AUTO: Initializing AutoFarGear()");
    addSequential(new MoveBB(-0.7, 110));
    addSequential(new TurnLeftBB(-0.7, 49));
    addSequential(new Timer(0.5));
    addSequential(new PlaceGear());
    addSequential(new MoveBB(0.3, 12));
  }
}
