package org.usfirst.frc.team4930.robot;

import org.usfirst.frc.team4930.robot.commands.ClearBalls;
import org.usfirst.frc.team4930.robot.commands.Climb;
import org.usfirst.frc.team4930.robot.commands.PlaceGear;
import org.usfirst.frc.team4930.robot.commands.Playback;
import org.usfirst.frc.team4930.robot.commands.Record;
import org.usfirst.frc.team4930.robot.commands.ShiftDown;
import org.usfirst.frc.team4930.robot.commands.ShiftUp;
import org.usfirst.frc.team4930.robot.commands.ShootCommandGroup;
import org.usfirst.frc.team4930.robot.commands.StopRecord;

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
  public static Joystick joystick2;

  public static JoystickButton joystick0button11;

  public static JoystickButton joystick0Button2;
  public static JoystickButton joystick0Button3;
  public static JoystickButton joystick2Button8;
  public static JoystickButton joystick2Button10;
  public static JoystickButton joystick2Button12;

  public static JoystickButton joystick2Button7;
  public static JoystickButton joystick2Button9;
  public static JoystickButton joystick2Button11;

  public static JoystickButton joystick1Button3;
  public static JoystickButton joystick1Button4;

  public static JoystickButton joystick1Button12;

  public OI() {
    joystick0 = new Joystick(0);
    joystick1 = new Joystick(1);
    joystick2 = new Joystick(2);

    joystick0Button2 = new JoystickButton(joystick0, 2);
    joystick0Button2.whenPressed(new ShiftUp());

    joystick0Button3 = new JoystickButton(joystick0, 3);
    joystick0Button3.whenPressed(new ShiftDown());

    joystick2Button8 = new JoystickButton(joystick2, 8);
    joystick2Button8.whenPressed(new Record());

    joystick2Button10 = new JoystickButton(joystick2, 10);
    joystick2Button10.whenPressed(new StopRecord());

    joystick2Button12 = new JoystickButton(joystick2, 12);
    joystick2Button12.whenPressed(new Playback());

    joystick0button11 = new JoystickButton(joystick0, 11);
    joystick0button11.whileHeld(new Climb());

    joystick1Button3 = new JoystickButton(joystick1, 3);
    joystick1Button3.whileHeld(new ShootCommandGroup());

    joystick1Button4 = new JoystickButton(joystick1, 4);
    joystick1Button4.whileHeld(new ClearBalls());

    joystick1Button12 = new JoystickButton(joystick1, 12);
    joystick1Button12.whileHeld(new PlaceGear());

    // used the prevent accidental recording button presses
    joystick2Button7 = new JoystickButton(joystick2, 7);
    joystick2Button9 = new JoystickButton(joystick2, 9);
    joystick2Button11 = new JoystickButton(joystick2, 11);
  }

  public double getJoystick0() {
    return joystick0.getY();
  }

  public double getJoystick1() {
    return joystick1.getY();
  }

  public boolean getJoystick2Button7() {
    return joystick2Button7.get();
  }

  public boolean getJoystick2Button9() {
    return joystick2Button9.get();
  }

  public boolean getJoystick2Button11() {
    return joystick2Button11.get();
  }
}
