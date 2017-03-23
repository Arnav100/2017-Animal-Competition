package org.usfirst.frc.team4930.robot.sensors;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;

public class ToggleSwitch
{

  public String getAlliance() {
    String side;
    if (RobotMap.allianceToggleSwitch.get()) {
      Robot.isRed = true;
      side = "Red";
    } else {
      Robot.isRed = false;
      side = "Blue";
    }
    return side;
  }

  public String getRoutineOrReplay() {
    String auto = null;
    if (RobotMap.replayToggleSwitch.get()) {
      Robot.isReplayOn = true;
      auto = "ON";
    } else {
      Robot.isReplayOn = false;
      auto = "OFF";
    }
    return auto;
  }

}
