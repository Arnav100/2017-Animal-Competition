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
  private double dtLeft, dtRight;

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
        dtLeft = scanner.nextDouble();
        dtRight = scanner.nextDouble();
        // check if alliance matches toggle switch
        if (Objects.equals(alliance, Robot.allianceToggle.getSide())) {
          RobotMap.dtMasterMotors.tankDrive(dtLeft, dtRight);
        } else {
          RobotMap.dtMasterMotors.tankDrive(dtRight, dtLeft);
        }
        // intake
        RobotMap.gadgetL.set(scanner.nextDouble());
        // intake
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
