package org.usfirst.frc.team4930.robot;

import java.util.HashMap;
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.*;

public class RobotMap
{

  // motor controllers
  public static CANTalon motor;

  // pneumatic system
  public static Compressor compressor;
  public static Solenoid solenoid;

  // robot sensors
  public static AnalogPotentiometer dial;
  public static DigitalInput toggleSwitch;
  public static ADXRS450_Gyro gyro;

  // static values
  public static HashMap<String, Double> values = new HashMap<String, Double>();

  public static void init() {

    motor = new CANTalon(1);

    // initial static values with (+/-) control
    values.put("motor", 0.45);

    // setup drive train encoders
    motor.setFeedbackDevice(FeedbackDevice.QuadEncoder);

    // instantiate pneumatic system
    compressor = new Compressor(50); // device id
    solenoid = new Solenoid(50, 5); // device id, channel

    motor.setSafetyEnabled(true);

    // instantiate sensors
    dial = new AnalogPotentiometer(0, 300, 0); // channel, range, offset
    toggleSwitch = new DigitalInput(9);
  }
}
