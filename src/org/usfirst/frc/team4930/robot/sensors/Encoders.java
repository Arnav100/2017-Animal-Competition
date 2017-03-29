package org.usfirst.frc.team4930.robot.sensors;

import org.usfirst.frc.team4930.robot.RobotMap;

public class Encoders
{
  public double left, right;

  public Encoders() {
    reset();
    left = leftPosRaw();
    right = rightPosRaw();
  }

  // reset encoder positions
  public void reset() {
    RobotMap.dtLMaster.setEncPosition(0);
    RobotMap.dtRMaster.setEncPosition(0);
  }

  // left position
  public int leftPosInches() {
    return (int) (this.leftPosRaw() / 360);
  }

  // right position in inches
  public int rightPosInches() {
    return (int) (this.rightPosRaw() / 360) * -1;
  }

  // left position raw values
  public double leftPosRaw() {
    return RobotMap.dtLMaster.getEncPosition();
  }

  // right position raw values
  public double rightPosRaw() {
    return RobotMap.dtRMaster.getEncPosition();
  }

}
