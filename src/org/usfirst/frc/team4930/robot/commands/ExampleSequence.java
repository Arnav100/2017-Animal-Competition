package org.usfirst.frc.team4930.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ExampleSequence extends CommandGroup
{
  public ExampleSequence() {
    addParallel(new ShootFuel());
  }
}
