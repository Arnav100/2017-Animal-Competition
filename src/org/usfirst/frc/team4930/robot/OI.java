package org.usfirst.frc.team4930.robot;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI
{
  // joysticks 0-1-2
  public Joystick j0 = new Joystick(0);

  // all joystick0 buttons
  public JoystickButton j0b0 = new JoystickButton(j0, 0);
  public JoystickButton j0b1 = new JoystickButton(j0, 1);
  public JoystickButton j0b2 = new JoystickButton(j0, 2);
  public JoystickButton j0b3 = new JoystickButton(j0, 3);
  public JoystickButton j0b4 = new JoystickButton(j0, 4);
  public JoystickButton j0b5 = new JoystickButton(j0, 5);
  public JoystickButton j0b6 = new JoystickButton(j0, 6);
  public JoystickButton j0b7 = new JoystickButton(j0, 7);
  public JoystickButton j0b8 = new JoystickButton(j0, 8);
  public JoystickButton j0b9 = new JoystickButton(j0, 9);
  public JoystickButton j0b10 = new JoystickButton(j0, 10);
  public JoystickButton j0b11 = new JoystickButton(j0, 11);
  public JoystickButton j0b12 = new JoystickButton(j0, 12);

  public OI() {

    // joystick0 button actions
    j0b1.whileHeld(new RotateMotor());
    j0b7.whenPressed(new ValueChangeDown("motor"));
    j0b7.whenPressed(new ValueChangeDown("motor"));
    j0b8.whenPressed(new ReplayRecord());
    j0b10.whenPressed(new ReplayStopRecord());
    j0b12.whenPressed(new ReplayPlayback());
  }
}
