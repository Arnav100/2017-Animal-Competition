package org.usfirst.frc.team4930.robot;

import org.usfirst.frc.team4930.robot.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI
{
  public static Joystick joystick0;
  public static Joystick joystick1;
  public static Joystick joystick2;

  public static JoystickButton joystick0Button1;
  public static JoystickButton joystick0Button4;
  public static JoystickButton joystick0Button5;
  public static JoystickButton joystick0Button6;

  public static JoystickButton joystick1Button1;
  public static JoystickButton joystick1Button2;

  public static JoystickButton joystick2Button1;
  public static JoystickButton joystick2Button2;
  public static JoystickButton joystick2Button3;
  public static JoystickButton joystick2Button4;
  public static JoystickButton joystick2Button5;
  public static JoystickButton joystick2Button7;
  public static JoystickButton joystick2Button8;
  public static JoystickButton joystick2Button9;
  public static JoystickButton joystick2Button10;
  public static JoystickButton joystick2Button11;
  public static JoystickButton joystick2Button12;

  public OI() {
    joystick0 = new Joystick(0);
    joystick1 = new Joystick(1);
    joystick2 = new Joystick(2);

    // setup buttons
    joystick0Button1 = new JoystickButton(joystick0, 1);
    joystick0Button4 = new JoystickButton(joystick0, 4);
    joystick0Button6 = new JoystickButton(joystick0, 6);

    joystick1Button1 = new JoystickButton(joystick1, 1);
    joystick1Button2 = new JoystickButton(joystick1, 2);

    joystick2Button1 = new JoystickButton(joystick2, 1);
    joystick2Button2 = new JoystickButton(joystick2, 2);
    joystick2Button3 = new JoystickButton(joystick2, 3);
    joystick2Button4 = new JoystickButton(joystick2, 4);
    joystick2Button7 = new JoystickButton(joystick2, 7);
    joystick2Button8 = new JoystickButton(joystick2, 8);
    joystick2Button9 = new JoystickButton(joystick2, 9);
    joystick2Button10 = new JoystickButton(joystick2, 10);
    joystick2Button11 = new JoystickButton(joystick2, 11);
    joystick2Button12 = new JoystickButton(joystick2, 12);

    // attach commands to buttons
    joystick0Button1.whenPressed(new ShiftToggle());
    joystick0Button4.whenPressed(new ShiftDown());
    joystick0Button6.whenPressed(new ShiftUp());

    joystick1Button1.whileHeld(new Intake());
    joystick1Button2.whileHeld(new Outtake());

    joystick2Button1.whileHeld(new ShootCommandGroup());
    joystick2Button2.whenPressed(new PlaceGear());
    joystick2Button3.whileHeld(new Climb());
    joystick2Button4.whileHeld(new ClearBalls());
    joystick2Button8.whenPressed(new Record());
    joystick2Button10.whenPressed(new StopRecord());
    joystick2Button12.whenPressed(new Playback());
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
