package org.usfirst.frc.team4930.robot.autonomous;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * Auto Dial (06r): Drive short and shoot.
 * Red/Blue: Determines direction of ReplayCode.
 * ReplayCode: Run ReplayCode if ON.
 *
 *     s<-[<]         [>]->s
 *   b _____________________ r
 */
public class Auto06 extends CommandGroup
{
  public Auto06() {

    System.out.println("AUTO 06: Initializing");

    if (!Robot.isRed) {
      addSequential(new MoveLeftSideBB(0.7, 45));
      addSequential(new MoveRightSideBB(0.7, 90));
    } else {
      addSequential(new MoveRightSideBB(0.7, 45));
      addSequential(new MoveLeftSideBB(0.7, 90));
    }

    addParallel(new ShootFuel(), 5);
    addParallel(new LoadShooter(), 5);
    addParallel(new AgitateFuel(), 5);
    addSequential(new Timer(5.0));

    if (Robot.isReplayOn) {
      addSequential(new ReplayPlayback());
    }

  }
}
