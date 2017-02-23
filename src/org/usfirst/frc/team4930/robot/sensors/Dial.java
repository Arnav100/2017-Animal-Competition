package org.usfirst.frc.team4930.robot.sensors;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Dial extends Subsystem
{
  protected void initDefaultCommand() {}

  static public double getDial() {

    double autoSwitch = RobotMap.dial.get();

    double dialNum = (autoSwitch + 4) / (360 / 11);

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
