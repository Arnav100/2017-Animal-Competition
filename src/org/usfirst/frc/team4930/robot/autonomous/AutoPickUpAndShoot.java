package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.commands.IntakeFuel;
import org.usfirst.frc.team4930.robot.commands.ShootFuel;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoPickUpAndShoot extends CommandGroup
{
  public AutoPickUpAndShoot() {
    addParallel(new MoveBB(0.7, 81));
    addParallel(new IntakeFuel(), 4);
    addSequential(new TurnLeftBB(0.7, 30));
    addSequential(new ShootFuel());
  }

}
