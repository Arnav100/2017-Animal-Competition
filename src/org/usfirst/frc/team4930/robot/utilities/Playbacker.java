package org.usfirst.frc.team4930.robot.utilities;

import java.io.*;
import java.util.Scanner;
import org.usfirst.frc.team4930.robot.Robot;

public class Playbacker
{

  private Scanner scanner;
  private boolean onTime;
  private long startTime;
  private double nextTimestamp;

  // set boolean values, instaniate scanner, and set the start time
  public void setupPlayback() throws FileNotFoundException {
    scanner = new Scanner(new File(Robot.replayFilePath));
    scanner.useDelimiter(",|\\n");
    onTime = true;
    startTime = System.currentTimeMillis();
  }

  // sets the motor values in order if the current time matches the timestamp
  public void play() {
    if ((scanner != null) && scanner.hasNextDouble()) {
      if (onTime) {
        nextTimestamp = scanner.nextDouble();
      }
      double timeDelta = nextTimestamp - (System.currentTimeMillis() - startTime);
      if (timeDelta <= 0) {
        String side = scanner.next();
        double joystick0Y;
        double joystick1Y;
        if (side == "R") {
          // red side
          joystick0Y = scanner.nextDouble();
          joystick1Y = scanner.nextDouble();
        } else {
          // blue side mirrors red side
          joystick1Y = scanner.nextDouble();
          joystick0Y = scanner.nextDouble();
        }
        Robot.driveTrain.move(joystick0Y, joystick1Y);
        // intake value
        Robot.intake.in(scanner.nextDouble());
        // gear gadget value
        Robot.gearGadget.open(scanner.nextDouble());
        // loader value
        Robot.loader.load(scanner.nextDouble());
        // shooter value
        Robot.shooter.shoot(scanner.nextDouble());
        // currently on time
        onTime = true;
      } else {
        // wait until the current time matches the timestamp
        onTime = false;
      }
    } else {
      Robot.isPlaying = false;
    }
  }

  // stop drive train and stop scanner
  public void endPlayback() {
    Robot.driveTrain.stop();
    if (scanner != null) {
      scanner.close();
      scanner = null;
    }
  }
}
