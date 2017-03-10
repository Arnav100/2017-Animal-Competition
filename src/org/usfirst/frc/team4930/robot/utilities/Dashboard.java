package org.usfirst.frc.team4930.robot.utilities;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard
{
  
	
public void update() { //

    // put dial number and selected replay
    SmartDashboard.putString("Dial Number: ", Robot.dialNumber.toString());
    SmartDashboard.putString("Replay Selected: ", Robot.autoDescription);
    SmartDashboard.putNumber("Dial Raw: ", RobotMap.dial.get());
    SmartDashboard.putBoolean("Toggle Switch", RobotMap.toggleSwitch.get());
    SmartDashboard.putString("Toggle Switch", Robot.toggleSwitch.getSide());

    // replay is or is not recording
    SmartDashboard.putBoolean("isRecording: ", Robot.isRecording);
    SmartDashboard.putBoolean("isPlaying: ", Robot.isReplaying);

    // sensor data
    SmartDashboard.putNumber("Gyro Angle: ", RobotMap.gyro.getAngle());

    // put hard code values
    SmartDashboard.putNumber("Agitate Value", RobotMap.values.get("agitate"));
    SmartDashboard.putNumber("Loader Value", RobotMap.values.get("loader"));
    SmartDashboard.putNumber("Shooter Value", RobotMap.values.get("shooter"));
    SmartDashboard.putNumber("ClearLoader Value", RobotMap.values.get("clear_loader"));
    SmartDashboard.putNumber("ClearShooter Value", RobotMap.values.get("clear_shooter"));
    SmartDashboard.putNumber("OpenGadget Value", RobotMap.values.get("open_gadget"));
    SmartDashboard.putNumber("CloseGadget Value", RobotMap.values.get("close_gadget"));
    SmartDashboard.putNumber("IntakeIn Value", RobotMap.values.get("intake_in"));
    SmartDashboard.putNumber("IntakeOut Value", RobotMap.values.get("intake_out"));
  }
}
