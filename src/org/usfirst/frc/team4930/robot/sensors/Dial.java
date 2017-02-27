package org.usfirst.frc.team4930.robot.sensors;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;
import org.usfirst.frc.team4930.robot.autonomous.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Dial extends Subsystem
{
  protected void initDefaultCommand() {}

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
  public void setupAutoReplay() {
    // check on board dial for auto
    switch (getDialNumber()) {
      case 1:
        Robot.autoSelected = "(1) New Gear";
        Robot.replayFilePath = "/home/lvuser/CSVs/NearGear.csv";
        Robot.autoCommand = new NearGear();
        break;
      case 2:
        Robot.autoSelected = "(2) Middle Gear";
        Robot.replayFilePath = "/home/lvuser/CSVs/MiddleGear.csv";
        Robot.autoCommand = new MiddleGear();
        break;
      case 3:
        Robot.autoSelected = "(3) Far Gear";
        Robot.replayFilePath = "/home/lvuser/CSVs/FarGear.csv";
        Robot.autoCommand = new FarGear();
        break;
      case 4:
        Robot.autoSelected = "(4) Near Replay";
        Robot.replayFilePath = "/home/lvuser/CSVs/NearGear.csv";
        Robot.autoCommand = new Replay();
        break;
      case 5:
        Robot.autoSelected = "(5) Middle Replayr";
        Robot.replayFilePath = "/home/lvuser/CSVs/MiddleGear.csv";
        Robot.autoCommand = new Replay();
        break;
      case 6:
        Robot.autoSelected = "(6) Far Replay";
        Robot.replayFilePath = "/home/lvuser/CSVs/FarGear.csv";
        Robot.autoCommand = new Replay();
        break;
      case 7:
        Robot.autoSelected = "(7) Open Replay Seven";
        Robot.replayFilePath = "/home/lvuser/CSVs/Open7.csv";
        Robot.autoCommand = new Replay();
        break;
      case 8:
        Robot.autoSelected = "(8) Open Replay Eight";
        Robot.replayFilePath = "/home/lvuser/CSVs/Open8.csv";
        Robot.autoCommand = new Replay();
        break;
      case 9:
        Robot.autoSelected = "(9) Open Replay Nine";
        Robot.replayFilePath = "/home/lvuser/CSVs/Open9.csv";
        Robot.autoCommand = new Replay();
        break;
      case 10:
        Robot.autoSelected = "(10) Practice Field Replay";
        Robot.replayFilePath = "/home/lvuser/CSVs/Practice.csv";
        Robot.autoCommand = new Replay();
        break;
      default:
        Robot.autoCommand = new DoNothing();
        Robot.autoSelected = "(0) Do Nothing";
        Robot.replayFilePath = "";
    }
  }
}
