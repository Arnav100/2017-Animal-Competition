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

  // all joystick0 buttons
  public JoystickButton j0b1 = new JoystickButton(j0, 1);
  // public JoystickButton j0b2 = new JoystickButton(j0, 2);
  // public JoystickButton j0b3 = new JoystickButton(j0, 3);
  public JoystickButton j0b4 = new JoystickButton(j0, 4);
  // public JoystickButton j0b5 = new JoystickButton(j0, 5);
  // public JoystickButton j0b6 = new JoystickButton(j0, 6);
  public JoystickButton j0b7 = new JoystickButton(j0, 7);
  public JoystickButton j0b8 = new JoystickButton(j0, 8);
  public JoystickButton j0b9 = new JoystickButton(j0, 9);
  public JoystickButton j0b10 = new JoystickButton(j0, 10);
  public JoystickButton j0b11 = new JoystickButton(j0, 11);
  public JoystickButton j0b12 = new JoystickButton(j0, 12);

  // all joystick1 buttons
  public JoystickButton j1b1 = new JoystickButton(j1, 1);
  // public JoystickButton j1b2 = new JoystickButton(j1, 2);
  // public JoystickButton j1b3 = new JoystickButton(j1, 3);
  // public JoystickButton j1b4 = new JoystickButton(j1, 4);
  // public JoystickButton j1b5 = new JoystickButton(j1, 5);
  // public JoystickButton j1b6 = new JoystickButton(j1, 6);
  public JoystickButton j1b7 = new JoystickButton(j1, 7);
  public JoystickButton j1b8 = new JoystickButton(j1, 8);
  public JoystickButton j1b9 = new JoystickButton(j1, 9);
  public JoystickButton j1b10 = new JoystickButton(j1, 10);
  public JoystickButton j1b11 = new JoystickButton(j1, 11);
  public JoystickButton j1b12 = new JoystickButton(j1, 12);

  // all joystick2 buttons
  public JoystickButton j2b1 = new JoystickButton(j2, 1);
  public JoystickButton j2b2 = new JoystickButton(j2, 2);
  public JoystickButton j2b3 = new JoystickButton(j2, 3);
  public JoystickButton j2b4 = new JoystickButton(j2, 4);
  // public JoystickButton j2b5 = new JoystickButton(j2, 5);
  // public JoystickButton j2b6 = new JoystickButton(j2, 6);
  public JoystickButton j2b7 = new JoystickButton(j2, 7);
  public JoystickButton j2b8 = new JoystickButton(j2, 8);
  public JoystickButton j2b9 = new JoystickButton(j2, 9);
  public JoystickButton j2b10 = new JoystickButton(j2, 10);
  public JoystickButton j2b11 = new JoystickButton(j2, 11);
  public JoystickButton j2b12 = new JoystickButton(j2, 12);

  public OI() {

    // joystick0 button actions
    j0b1.whileHeld(new IntakeFuel());
    j0b4.whileHeld(new UnloadHopper());
    j0b7.whenPressed(new ValueChangeUp("agitate"));
    j0b8.whenPressed(new ValueChangeDown("agitate"));
    j0b9.whenPressed(new ValueChangeUp("loader"));
    j0b10.whenPressed(new ValueChangeDown("loader"));
    j0b11.whenPressed(new ValueChangeUp("shooter"));
    j0b12.whenPressed(new ValueChangeDown("shooter"));

    // joystick1 button actions
    j1b1.whenPressed(new ShiftUp());
    j1b1.whenReleased(new ShiftDown());
    j1b7.whenPressed(new ValueChangeUp("intake_in"));
    j1b8.whenPressed(new ValueChangeDown("intake_in"));
    j1b9.whenPressed(new ValueChangeUp("intake_out"));
    j1b10.whenPressed(new ValueChangeDown("intake_out"));
    j1b11.whenPressed(new ValueChangeUp("clear_fuel"));
    j1b12.whenPressed(new ValueChangeDown("clear_fuel"));

    // joystick2 button actions
    j2b1.whileHeld(new ShootingSequence());
    j2b2.whenPressed(new PlaceGear());
    j2b3.whileHeld(new ClimbRope());
    j2b4.whileHeld(new ClearShooter());
    j2b8.whenPressed(new ReplayRecord());
    j2b10.whenPressed(new ReplayStopRecord());
    j2b12.whenPressed(new ReplayPlayback());
  }
}
