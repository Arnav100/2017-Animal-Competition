package org.usfirst.frc.team4930.robot.utilities;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard
{

  public void update() { //

    // put selected replay and alliance side
    SmartDashboard.putString("Replay Selected: ", Robot.autoDescription);
    SmartDashboard.putString("Alliance Side: ", Robot.allianceToggle.getSide());

    // put hard code values
    SmartDashboard.putNumber("Motor Value", RobotMap.values.get("motor") * 100);

    // test values
    // SmartDashboard.putNumber("Gyro Angle", Robot.gyro.getAngle());
    // SmartDashboard.putNumber("Encoder Value", Robot.encoders.posInches());

    SmartDashboard.putBoolean("Is Recording", Robot.isRecording);
    SmartDashboard.putBoolean("Is RePlaying", Robot.isReplaying);
  }
}
