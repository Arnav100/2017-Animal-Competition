package org.usfirst.frc.team4930.robot.utilities;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard
{

  long currentTime;

  public Dashboard() {
    currentTime = System.currentTimeMillis();
  }

  public void update() {

    // limit smart dashboard updates to once every half second
    if (System.currentTimeMillis() > (currentTime + 500)) {

      currentTime = System.currentTimeMillis();

      Robot.dial.setSelectedReplay();

      // put hard code values
      SmartDashboard.putString("1", "Agitate: " + String.valueOf(RobotMap.values.get("agitate") * 100));
      SmartDashboard.putString("2", "Loader: " + String.valueOf(RobotMap.values.get("loader") * 100));
      SmartDashboard.putString("3", "Shooter: " + String.valueOf(RobotMap.values.get("shooter") * 100));
      SmartDashboard.putString("4", "Intake: " + String.valueOf(RobotMap.values.get("intake_in") * 100));
      SmartDashboard.putString("5", "Unload: " + String.valueOf(RobotMap.values.get("intake_out") * 100));
      SmartDashboard.putString("6", "Clear: " + String.valueOf(RobotMap.values.get("clear_fuel") * 100));

      // put sensor values
      SmartDashboard.putString("7", "Gyro Angle: " + String.valueOf(Robot.gyro.getAngle()));
      SmartDashboard.putString("8", "Left Encoder: " + String.valueOf(Robot.encoders.leftPosInches()));
      SmartDashboard.putString("9", "Right Encoder: " + String.valueOf(Robot.encoders.rightPosInches()));

      // put dial and alliance side
      SmartDashboard.putString("10", "Replay Selected: " + Robot.autoDescription);
      SmartDashboard.putString("11", "Alliance Side: " + Robot.allianceToggle.getSide());

    }

  }
}
