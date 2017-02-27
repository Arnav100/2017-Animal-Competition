package org.usfirst.frc.team4930.robot.sensors;

import org.usfirst.frc.team4930.robot.RobotMap;

public class Encoders
{
  public double left, right;

  public Encoders() {
    reset();
    left = lPos();
    right = rPos();
  }

  // reset encoder positions
  public void reset() {
    RobotMap.dtLMaster.setEncPosition(0);
    RobotMap.dtRMaster.setEncPosition(0);
  }

  // left position
  public double lPos() {
    return RobotMap.dtLMaster.getEncPosition();
  }

  // right position
  public double rPos() {
    return RobotMap.dtLMaster.getEncPosition();
  }

}
