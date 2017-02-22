package org.usfirst.frc.team4930.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class ShootCommandGroup extends CommandGroup
{

  public ShootCommandGroup() {
    addParallel(new SpinUpShooter());
    addParallel(new Load());
    addParallel(new Agitate());
  }
}
