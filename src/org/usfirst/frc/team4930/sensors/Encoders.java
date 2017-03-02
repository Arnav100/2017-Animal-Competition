package org.usfirst.frc.team4930.sensors;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;

public class Encoders
{

  private boolean isRunning;
  double startRight = 0;
  double startLeft = 0;

  public void reset() {

    RobotMap.driveTrainRightMaster.setEncPosition(0);
    RobotMap.driveTrainLeftMaster.setEncPosition(0);
    startRight = 0;
    startLeft = 0;
  }

  public void setStart() {
    startRight = RobotMap.driveTrainRightMaster.getEncPosition();
    startLeft = RobotMap.driveTrainLeftMaster.getEncPosition();

  }

  public void move(double speed, double inches) {
    isRunning = true;

    double distanceRight = (inches * 1900) + startRight;
    double distanceLeft = (inches * 1900) + startLeft;

    if (RobotMap.driveTrainRightMaster.getEncPosition() <= distanceRight
        && RobotMap.driveTrainLeftMaster.getEncPosition() <= distanceLeft) {
      Robot.driveTrain.move(speed, speed);
    } else {
      Robot.driveTrain.stop();
      isRunning = false;
    }
  }

  public boolean getRunning() {
    return isRunning;
  }

  public void stop() {
    Robot.driveTrain.stop();
  }
}
