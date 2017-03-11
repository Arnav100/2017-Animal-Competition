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
    SmartDashboard.putNumber("Agitate Value", RobotMap.values.get("agitate") * 100);
    SmartDashboard.putNumber("Loader Value", RobotMap.values.get("loader") * 100);
    SmartDashboard.putNumber("Shooter Value", RobotMap.values.get("shooter") * 100);
    SmartDashboard.putNumber("ClearLoader Value", RobotMap.values.get("clear_loader") * 100);
    SmartDashboard.putNumber("ClearShooter Value", RobotMap.values.get("clear_shooter") * 100);
    SmartDashboard.putNumber("OpenGadget Value", RobotMap.values.get("open_gadget") * 100);
    SmartDashboard.putNumber("CloseGadget Value", RobotMap.values.get("close_gadget") * 100);
    SmartDashboard.putNumber("IntakeIn Value", RobotMap.values.get("intake_in") * 100);
    SmartDashboard.putNumber("IntakeOut Value", RobotMap.values.get("intake_out") * 100);

    // test values
    SmartDashboard.putNumber("Gyro Angle", Robot.gyro.getAngle());
  }
}
