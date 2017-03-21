package org.usfirst.frc.team4930.robot.sensors;

import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;

public class Accelerometer
{
  BuiltInAccelerometer accel;

  double initialCloseGadget;

  public double maxX, maxY, maxZ = 0.0;

  public Accelerometer() {
    accel = new BuiltInAccelerometer();
    initialCloseGadget = RobotMap.values.get("close_gadget");
  }

  public double getX() {
    return accel.getX();
  }

  public double getY() {
    return accel.getX();
  }

  public double getZ() {
    return accel.getX();
  }

  public void maxXYZ() {
    // get max X
    double x = getX();
    if (x > maxX) {
      maxX = x;
    }
    // get max Y
    double y = getY();
    if (y > maxY) {
      maxY = y;
    }
    // get max Z
    double z = getZ();
    if (z > maxZ) {
      maxZ = z;
    }
  }

  public void resetMax() {
    maxX = 0.0;
    maxY = 0.0;
    maxZ = 0.0;
  }

  public void overrideGearGadget() {
    // @todo monitor max accel and adjust accordingly
    if (Math.abs(getZ()) > 8) {
      RobotMap.values.put("close_gadget", 1.0);
    } else {
      RobotMap.values.put("close_gadget", initialCloseGadget);
    }
  }
}
