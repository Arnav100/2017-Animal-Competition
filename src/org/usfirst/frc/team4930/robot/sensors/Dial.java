package org.usfirst.frc.team4930.robot.sensors;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;
import org.usfirst.frc.team4930.robot.autonomous.Auto00;
import org.usfirst.frc.team4930.robot.autonomous.Auto01;
import org.usfirst.frc.team4930.robot.autonomous.Auto02;
import org.usfirst.frc.team4930.robot.autonomous.Auto03;
import org.usfirst.frc.team4930.robot.autonomous.Auto04;
import org.usfirst.frc.team4930.robot.autonomous.Auto05;
import org.usfirst.frc.team4930.robot.autonomous.Auto06;
import org.usfirst.frc.team4930.robot.autonomous.Auto07;
import org.usfirst.frc.team4930.robot.autonomous.Auto08;
import org.usfirst.frc.team4930.robot.autonomous.Auto09;
import org.usfirst.frc.team4930.robot.autonomous.Auto10;

public class Dial
{

  // return 0-10 dial number after normalizing to nearest 11th point
  static public int getDialNumber() {
    double autoSwitch = RobotMap.dial.get();
    double dialNum = (autoSwitch + 7) / (360 / 11);
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
          Robot.autoDescription = "(01) Drive Forward";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto01";
          Robot.autoCommand = new Auto01();
          break;
        case 2:
          Robot.autoDescription = "(02) Replay Code";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto02";
          Robot.autoCommand = new Auto02();
          break;
        case 3:
          Robot.autoDescription = "(03) Replay Code";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto03";
          Robot.autoCommand = new Auto03();
          break;
        case 4:
          Robot.autoDescription = "(04) Replay Code";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto04";
          Robot.autoCommand = new Auto04();
          break;
        case 5:
          Robot.autoDescription = "(05) Replay Code";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto05";
          Robot.autoCommand = new Auto05();
          break;
        case 6:
          Robot.autoDescription = "(06) Replay Code";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto06";
          Robot.autoCommand = new Auto06();
          break;
        case 7:
          Robot.autoDescription = "(07) Replay Code";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto07";
          Robot.autoCommand = new Auto07();
          break;
        case 8:
          Robot.autoDescription = "(08) Replay Code";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto08";
          Robot.autoCommand = new Auto08();
          break;
        case 9:
          Robot.autoDescription = "(09) Replay Code";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto09";
          Robot.autoCommand = new Auto09();
          break;
        case 10:
          Robot.autoDescription = "(10) Replay Code";
          Robot.replayFilePath = "/home/lvuser/CSVs/Auto10";
          Robot.autoCommand = new Auto10();
          break;
        default:
          Robot.dialNumber = 0;
          Robot.autoDescription = "(00) Do Nothing";
          Robot.replayFilePath = "";
          Robot.autoCommand = new Auto00();
      }
      System.out.println("AutoDial: " + Robot.autoDescription);
    }
  }
}
