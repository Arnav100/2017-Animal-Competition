package org.usfirst.frc.team4930.robot.utilities;

import java.io.*;
import java.util.Scanner;
import org.usfirst.frc.team4930.robot.Robot;

public class ReplayPlayer
{

  private Scanner scanner;
  private boolean onTime;
  private long startTimestamp;
  private double nextTimestamp;

  // instantiate scanner and set the start time
  public void setup() throws FileNotFoundException {
    scanner = new Scanner(new File(Robot.replayFilePath));
    scanner.useDelimiter(",|\\n");
    onTime = true;
    startTimestamp = System.currentTimeMillis();
    Robot.isReplaying = true;
  }

  // set motor values if current time matches the start time
  public void play() {
    if ((scanner != null) && scanner.hasNextDouble()) {
      if (onTime) {
        nextTimestamp = scanner.nextDouble();
      }
      double timeDelta = nextTimestamp - (System.currentTimeMillis() - startTimestamp);
      if (timeDelta <= 0) {
        String alliance = scanner.next();
        double joystick0Y = scanner.nextDouble();
        double joystick1Y = scanner.nextDouble();
        // if alliance matches toggle switch
        if (alliance == "Red") {
          Robot.driveTrain.move(joystick0Y, joystick1Y);
        } else {
          Robot.driveTrain.move(joystick1Y, joystick0Y);
        }
        // gear gadget value
        Robot.gearGadget.move(scanner.nextDouble());
        // intake value
        Robot.intake.move(scanner.nextDouble());
        // loader value
        Robot.loader.move(scanner.nextDouble());
        // shooter value
        Robot.shooter.move(scanner.nextDouble());
        // currently on time
        onTime = true;
      } else {
        onTime = false;
      }
    }
  }

  // stop drive train and stop scanner
  public void end() {
    Robot.driveTrain.stop();
    Robot.isReplaying = false;
    if (scanner != null) {
      scanner.close();
      scanner = null;
    }
  }
}
