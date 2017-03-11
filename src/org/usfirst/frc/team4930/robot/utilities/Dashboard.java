package org.usfirst.frc.team4930.robot.utilities;

import org.usfirst.frc.team4930.robot.Robot;
import org.usfirst.frc.team4930.robot.RobotMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Dashboard
{

  public void update() { //

    // put selected replay and alliance side
    SmartDashboard.putString("Replay Selected: ", Robot.autoDescription);
    SmartDashboard.putString("Alliance Side: ", Robot.toggleSwitch.getSide());

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
