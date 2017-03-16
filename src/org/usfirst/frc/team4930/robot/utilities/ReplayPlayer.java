package org.usfirst.frc.team4930.robot.utilities;

import java.io.*;
import java.util.*;
import org.usfirst.frc.team4930.robot.*;

public class ReplayPlayer
{

  private Scanner scanner;
  private boolean onTime;
  private long startTimestamp, nextTimestamp, deltaTimestamp;
  private String alliance;
  private double value;

  // instantiate scanner and set the start time
  public void setup() throws FileNotFoundException {
    scanner = new Scanner(new File(Robot.replayFilePath));
    scanner.useDelimiter(",|\\n");
    onTime = true;
    alliance = Robot.allianceToggle.getSide();
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
        value = scanner.nextDouble();
        // check if alliance matches toggle switch
        if (Objects.equals(alliance, Robot.allianceToggle.getSide())) {
          RobotMap.motor.set(value);
        } else {
          RobotMap.motor.set(-value);
        }
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
    Robot.motor.stop();
    if (scanner != null) {
      scanner.close();
      scanner = null;
    }
  }
}
