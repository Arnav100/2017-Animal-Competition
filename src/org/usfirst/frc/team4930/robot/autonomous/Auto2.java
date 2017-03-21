package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.PlaceGear;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class Auto2 extends CommandGroup
{
  public Auto2() {
    System.out.println("AUTO: Initializing AutoMiddleGear()");
    addSequential(new MoveBB(-0.7, 66));
    addSequential(new Timer(0.5));
    addSequential(new PlaceGear());
    addSequential(new MoveBB(0.3, 12));
  }
}
