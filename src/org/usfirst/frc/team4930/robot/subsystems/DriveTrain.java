package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.RobotMap;
import org.usfirst.frc.team4930.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem
{
  public void initDefaultCommand() {
    setDefaultCommand(new TankDrive());
  }

  public void move(double left, double right) {
    RobotMap.driveTrainMasterMotors.tankDrive(-left, right);
  }

  public void toggleBrakeMode(boolean state) {
    RobotMap.driveTrainLeftMaster.enableBrakeMode(state);
    RobotMap.driveTrainLeftSlave1.enableBrakeMode(state);
    RobotMap.driveTrainLeftSlave2.enableBrakeMode(state);
    RobotMap.driveTrainRightMaster.enableBrakeMode(state);
    RobotMap.driveTrainRightSlave1.enableBrakeMode(state);
    RobotMap.driveTrainRightSlave2.enableBrakeMode(state);
  }

  public void stop() {
    RobotMap.driveTrainMasterMotors.stopMotor();
  }
}
