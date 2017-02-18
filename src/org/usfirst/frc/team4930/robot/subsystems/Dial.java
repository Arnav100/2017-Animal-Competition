package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Subsystem;

public class Dial extends Subsystem
{

  protected void initDefaultCommand() {}

  private double autoSwitch;

  private final int dials = 11;

  public double getDial() {

    autoSwitch = RobotMap.dialChooser.get();

    double dialNum = autoSwitch / (360 / dials);

    double floor = Math.floor(dialNum);

    if ((dialNum - floor) >= 0.5) {
      dialNum = Math.ceil(dialNum);
    }

    else if ((dialNum - floor) < 0.5) {
      dialNum = floor;
    }

    return dialNum;

  }
}
