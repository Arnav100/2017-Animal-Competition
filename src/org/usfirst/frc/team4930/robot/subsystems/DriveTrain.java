package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.*;
import org.usfirst.frc.team4930.robot.commands.TankDrive;

import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem
{
  public void initDefaultCommand() {
    setDefaultCommand(new TankDrive());
  }

  public void drive() {
    move(Robot.oi.j0.getY(), Robot.oi.j1.getY());
  }

  public void move(double left, double right) {
    RobotMap.dtMasterMotors.tankDrive(-left, right);
  }

  public void toggleBrakeMode(boolean state) {
    RobotMap.dtLMaster.enableBrakeMode(state);
    RobotMap.dtLSlave1.enableBrakeMode(state);
    RobotMap.dtLSlave2.enableBrakeMode(state);
    RobotMap.dtRMaster.enableBrakeMode(state);
    RobotMap.dtRSlave1.enableBrakeMode(state);
    RobotMap.dtRSlave2.enableBrakeMode(state);
  }

  public void stop() {
    RobotMap.dtMasterMotors.stopMotor();
  }
}
