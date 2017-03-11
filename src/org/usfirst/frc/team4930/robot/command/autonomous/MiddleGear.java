package org.usfirst.frc.team4930.robot.command.autonomous;

import org.usfirst.frc.team4930.robot.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class MiddleGear extends CommandGroup
{
  public MiddleGear() {

    addSequential(new EncoderMove(-0.3, -93.25));

    Robot.autoFile = "MiddleGearReplay";
    Robot.autoFilePath = new String("/home/lvuser/CSVs/" + Robot.autoFile + ".csv");
    addSequential(new Playback());
  }

}
