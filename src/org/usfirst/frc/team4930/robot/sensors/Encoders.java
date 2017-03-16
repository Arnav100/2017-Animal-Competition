package org.usfirst.frc.team4930.robot.sensors;

import org.usfirst.frc.team4930.robot.RobotMap;

public class Encoders
{
  public double pos;

  public Encoders() {
    reset();
    pos = posRaw();
  }

  // reset encoder positions
  public void reset() {
    RobotMap.motor.setEncPosition(0);
  }

  // position in inches
  public int posInches() {
    return (int) (posRaw() / 666) * -1;
  }

  // position raw values
  public double posRaw() {
    return RobotMap.motor.getEncPosition();
  }

}
