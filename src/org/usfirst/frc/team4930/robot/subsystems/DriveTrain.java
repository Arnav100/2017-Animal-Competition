package org.usfirst.frc.team4930.robot.subsystems;

import org.usfirst.frc.team4930.robot.*;
import org.usfirst.frc.team4930.robot.commands.TankDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveTrain extends Subsystem
{
  public double leftSide, rightSide;

  public void initDefaultCommand() {
    setDefaultCommand(new TankDrive());
  }

  public void move(double left, double right) {
    leftSide = left;
    rightSide = right;
    RobotMap.dtMasterMotors.tankDrive(-left, right);
  }

  public void drive() {
    double governor = 1.0;
    if (Robot.inLowGear) {
      governor = RobotMap.values.get("low_governor");
    } else {
      governor = RobotMap.values.get("high_governor");
    }
    double left = Robot.oi.j0.getY() * governor;
    double right = Robot.oi.j1.getY() * governor;
    move(left, right);
  }

  public void stop() {
    RobotMap.dtMasterMotors.stopMotor();
  }

  public void brakeMode(boolean state) {
    RobotMap.dtLMaster.enableBrakeMode(state);
    RobotMap.dtLSlave1.enableBrakeMode(state);
    RobotMap.dtLSlave2.enableBrakeMode(state);
    RobotMap.dtRMaster.enableBrakeMode(state);
    RobotMap.dtRSlave1.enableBrakeMode(state);
    RobotMap.dtRSlave2.enableBrakeMode(state);
  }
}
