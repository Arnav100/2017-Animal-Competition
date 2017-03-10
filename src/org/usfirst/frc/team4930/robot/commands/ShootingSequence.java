package org.usfirst.frc.team4930.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootingSequence extends CommandGroup
{
  public ShootingSequence() {
    addParallel(new ShootFuel());
    addParallel(new LoadShooter());
    addParallel(new AgitateFuel());
  }
}
