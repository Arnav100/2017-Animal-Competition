package org.usfirst.frc.team4930.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShotSequence extends CommandGroup
{
  public ShotSequence() {
    addParallel(new ShootFuel());
    addParallel(new LoadShooter());
    addParallel(new AgitateFuel());
  }
}
