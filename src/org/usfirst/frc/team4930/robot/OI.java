package org.usfirst.frc.team4930.robot;

import org.usfirst.frc.team4930.robot.commands.ClearBalls;
import org.usfirst.frc.team4930.robot.commands.ShootCommandGroup;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator interface to the commands
 * and command groups that allow control of the robot.
 */
public class OI
{
  public static Joystick joystick0;
  public static Joystick joystick1;

  public static JoystickButton joystick0Button3;
  public static JoystickButton joystick0Button4;

  public OI() {
    joystick0 = new Joystick(0);
    joystick1 = new Joystick(1);

    joystick0Button3 = new JoystickButton(joystick0, 3);
    joystick0Button3.whileHeld(new ShootCommandGroup());

    joystick0Button4 = new JoystickButton(joystick0, 4);
    joystick0Button4.whileHeld(new ClearBalls());
  }

  public double getJoystick0() {
    return joystick0.getY();
  }

  public double getJoystick1() {
    return joystick1.getY();
  }
}
