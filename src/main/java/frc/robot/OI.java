/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ClawClose;
import frc.robot.commands.ClawOpen;
import frc.robot.commands.DecramentIndex;
import frc.robot.commands.IncramentIndex;
import frc.robot.commands.IncramentSetPoint;
import frc.robot.commands.decramentSetPoint;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

// Buttons and Controller--------------------
  public Joystick stick = new Joystick(RobotMap.xboxcontroller);
  public Button rightBumper = new JoystickButton(stick, RobotMap.clawOpenButton);
  public Button leftBumper = new JoystickButton(stick, RobotMap.clawCloseButton);
  public Button aButton = new JoystickButton(stick, RobotMap.incramentIndexButton);
  public Button bButton = new JoystickButton(stick, RobotMap.decramentIndexButton);
  public Button xButton = new JoystickButton(stick, RobotMap.incramentSetPointButton);
  public Button yButton = new JoystickButton(stick, RobotMap.decramentSetPointButton);

  public OI() {

// Button Commands-------------------------
    bButton.whenPressed(new DecramentIndex());
    aButton.whenPressed(new IncramentIndex());
    rightBumper.whenPressed(new ClawOpen());
    leftBumper.whenPressed(new ClawClose());
    xButton.whenPressed(new IncramentSetPoint());
    yButton.whenPressed(new decramentSetPoint());
  }

  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
