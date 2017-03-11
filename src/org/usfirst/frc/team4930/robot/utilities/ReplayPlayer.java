package org.usfirst.frc.team4930.robot.utilities;

import java.io.*;
import java.util.*;
import org.usfirst.frc.team4930.robot.*;

public class ReplayPlayer
{

  private Scanner scanner;
  private boolean onTime;
  private long startTimestamp, nextTimestamp, deltaTimestamp;
  private String alliance, shifter_state;
  private double dtLeft, dtRight;

  // instantiate scanner and set the start time
  public void setup() throws FileNotFoundException {
    scanner = new Scanner(new File(Robot.replayFilePath));
    scanner.useDelimiter(",|\\n");
    onTime = true;
    alliance = Robot.toggleSwitch.getSide();
    startTimestamp = System.currentTimeMillis();
    Robot.isReplaying = true;
  }

  // set motor values if current time matches the start time
  public void play() {
    if ((scanner != null) && scanner.hasNext()) {
      if (onTime) {
        nextTimestamp = scanner.nextLong();
      }
      deltaTimestamp = nextTimestamp - (System.currentTimeMillis() - startTimestamp);
      if (deltaTimestamp <= 0) {
        alliance = scanner.next();
        shifter_state = scanner.next();
        // shift if needed
        if (Robot.inLowGear && Objects.equals(shifter_state, "High")) {
          Robot.shifter.highGear();
        }
        if (!Robot.inLowGear && Objects.equals(shifter_state, "Low")) {
          Robot.shifter.lowGear();
        }
        dtLeft = scanner.nextDouble();
        dtRight = scanner.nextDouble();
        // check if alliance matches toggle switch
        if (Objects.equals(alliance, Robot.toggleSwitch.getSide())) {
          // same alliance as recording
          RobotMap.dtLMaster.set(dtLeft);
          RobotMap.dtRMaster.set(dtRight);
        } else {
          // switch due to opposite alliance
          RobotMap.dtLMaster.set(dtRight);
          RobotMap.dtRMaster.set(dtLeft);
        }
        // gear gadget left
        RobotMap.gadgetL.set(scanner.nextDouble());
        // gear gadget right
        RobotMap.gadgetR.set(scanner.nextDouble());
        // intake
        RobotMap.intake.set(scanner.nextDouble());
        // loader
        RobotMap.loader.set(scanner.nextDouble());
        // shooter
        RobotMap.shooter.set(scanner.nextDouble());
        // currently on time
        onTime = true;
      } else {
        onTime = false;
      }
    } else {
      Robot.isReplaying = false;
    }
  }

  // stop drive train and stop scanner
  public void end() {
    Robot.driveTrain.stop();
    Robot.loader.stop();
    Robot.intake.stop();
    Robot.shooter.stop();
    Robot.gearGadget.close();
    if (scanner != null) {
      scanner.close();
      scanner = null;
    }
  }
}
