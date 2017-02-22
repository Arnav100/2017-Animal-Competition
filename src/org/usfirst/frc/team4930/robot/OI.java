package org.usfirst.frc.team4930.robot;

import org.usfirst.frc.team4930.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI
{
  // joysticks 0-1-2
  public Joystick j0 = new Joystick(0);
  public Joystick j1 = new Joystick(1);
  public Joystick j2 = new Joystick(2);

  // joystick0 buttons
  public JoystickButton j0b1 = new JoystickButton(j0, 1);
  public JoystickButton j0b4 = new JoystickButton(j0, 4);
  public JoystickButton j0b6 = new JoystickButton(j0, 6);

  // joystick1 buttons
  public JoystickButton j1b1 = new JoystickButton(j1, 1);
  public JoystickButton j1b2 = new JoystickButton(j1, 2);

  // joystick2 buttons
  public JoystickButton j2b1 = new JoystickButton(j2, 1);
  public JoystickButton j2b2 = new JoystickButton(j2, 2);
  public JoystickButton j2b3 = new JoystickButton(j2, 3);
  public JoystickButton j2b4 = new JoystickButton(j2, 4);
  public JoystickButton j2b7 = new JoystickButton(j2, 7);
  public JoystickButton j2b8 = new JoystickButton(j2, 8);
  public JoystickButton j2b9 = new JoystickButton(j2, 9);
  public JoystickButton j2b10 = new JoystickButton(j2, 10);
  public JoystickButton j2b11 = new JoystickButton(j2, 11);
  public JoystickButton j2b12 = new JoystickButton(j2, 12);

  public OI() {

    // joystick0 button actions
    j0b1.whenPressed(new ShiftToggle());
    j0b4.whenPressed(new ShiftDown());
    j0b6.whenPressed(new ShiftUp());

    // joystick1 button actions
    j1b1.whileHeld(new IntakeFuel());
    j1b2.whileHeld(new UnloadHopper());

    // joystick2 button actions
    j2b1.whileHeld(new ShootingCG());
    j2b2.whenPressed(new PlaceGear());
    j2b3.whileHeld(new ClimbRope());
    j2b4.whileHeld(new ClearShooter());
    j2b8.whenPressed(new ReplayRecord());
    j2b10.whenPressed(new ReplayStopRecord());
    j2b12.whenPressed(new ReplayPlayback());
  }

}
