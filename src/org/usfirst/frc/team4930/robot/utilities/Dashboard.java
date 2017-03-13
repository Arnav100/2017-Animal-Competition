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
    SmartDashboard.putNumber("Agitate", RobotMap.values.get("agitate") * 100);
    SmartDashboard.putNumber("Loader", RobotMap.values.get("loader") * 100);
    SmartDashboard.putNumber("Shooter", RobotMap.values.get("shooter") * 100);
    SmartDashboard.putNumber("Intake", RobotMap.values.get("intake_in") * 100);
    SmartDashboard.putNumber("Unload", RobotMap.values.get("intake_out") * 100);
    SmartDashboard.putNumber("Clear", RobotMap.values.get("clear_fuel") * 100);

    // test values
    SmartDashboard.putNumber("Gyro Angle", RobotMap.gyro.getAngle());

    SmartDashboard.putBoolean("Is Recording", Robot.isRecording);
    SmartDashboard.putBoolean("Is RePlaying", Robot.isReplaying);
  }
}
