package org.usfirst.frc.team4930.robot.sensors;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;
import org.usfirst.frc.team4930.robot.autonomous.*;

public class Dial
{

  // get dial number after normalizing to nearest 11th point
  static public int getDialNumber() {
    double autoSwitch = RobotMap.dial.get();
    double dialNum = (autoSwitch + 4) / (360 / 11);
    double floor = Math.floor(dialNum);
    if ((dialNum - floor) >= 0.5) {
      dialNum = Math.ceil(dialNum);
    } else {
      dialNum = floor;
    }
    return (int) dialNum;
  }

  // setup autonomous modes based on dial input
  public void setSelectedReplay() {
    Integer getDialNum = getDialNumber();
    if (getDialNum != Robot.dialNumber) {
      Robot.dialNumber = getDialNum;
      switch (Robot.dialNumber) {
        case 1:
          Robot.autoDescription = "(1) New Gear";
          Robot.replayFilePath = "/home/lvuser/CSVs/NearGear.csv";
          Robot.autoCommand = new AutoNearGear();
          break;
        case 2:
          Robot.autoDescription = "(2) Middle Gear";
          Robot.replayFilePath = "/home/lvuser/CSVs/MiddleGear.csv";
          Robot.autoCommand = new AutoMiddleGear();
          break;
        case 3:
          Robot.autoDescription = "(3) Far Gear";
          Robot.replayFilePath = "/home/lvuser/CSVs/FarGear.csv";
          Robot.autoCommand = new AutoFarGear();
          break;
        case 4:
          Robot.autoDescription = "(4) Near Replay";
          Robot.replayFilePath = "/home/lvuser/CSVs/NearGear.csv";
          Robot.autoCommand = new AutoReplay();
          break;
        case 5:
          Robot.autoDescription = "(5) Middle Replayr";
          Robot.replayFilePath = "/home/lvuser/CSVs/MiddleGear.csv";
          Robot.autoCommand = new AutoReplay();
          break;
        case 6:
          Robot.autoDescription = "(6) Far Replay";
          Robot.replayFilePath = "/home/lvuser/CSVs/FarGear.csv";
          Robot.autoCommand = new AutoReplay();
          break;
        case 7:
          Robot.autoDescription = "(7) Open Replay Seven";
          Robot.replayFilePath = "/home/lvuser/CSVs/Open7.csv";
          Robot.autoCommand = new AutoReplay();
          break;
        case 8:
          Robot.autoDescription = "(8) Open Replay Eight";
          Robot.replayFilePath = "/home/lvuser/CSVs/Open8.csv";
          Robot.autoCommand = new AutoReplay();
          break;
        case 9:
          Robot.autoDescription = "(9) Open Replay Nine";
          Robot.replayFilePath = "/home/lvuser/CSVs/Open9.csv";
          Robot.autoCommand = new AutoReplay();
          break;
        case 10:
          Robot.autoDescription = "(10) Practice Field Replay";
          Robot.replayFilePath = "/home/lvuser/CSVs/Practice.csv";
          Robot.autoCommand = new AutoReplay();
          break;
        default:
          Robot.dialNumber = 0;
          Robot.autoDescription = "(0) Do Nothing";
          Robot.replayFilePath = "";
          Robot.autoCommand = new AutoDoNothing();
      }
    }
  }
}
