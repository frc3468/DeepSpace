/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.ClawClose;
import frc.robot.commands.ClawOpen;
import frc.robot.commands.DecramentIndex;
import frc.robot.commands.HighestLift;
import frc.robot.commands.IncramentIndex;
// import frc.robot.commands.LowerLift;
import frc.robot.commands.LowestLift;
import frc.robot.commands.MidLiftOne;
import frc.robot.commands.MidLiftTwo;
// import frc.robot.commands.RaiseLift;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  // Controller Mapped
  public Joystick stick = new Joystick(RobotMap.xboxcontroller);
  // public Button aButton = new JoystickButton(stick,RobotMap.lowestLiftButton);
  // public Button bButton = new JoystickButton(stick,RobotMap.midLiftOneButton);
  // public Button xButton = new JoystickButton(stick,RobotMap.midLiftTwoButton);
  // public Button yButton = new JoystickButton(stick,RobotMap.highestLiftButton);
  // public Button dPadUp = new JoystickButton(stick,RobotMap.wristUpButton);
  // public Button dPadLeft = new JoystickButton(stick,RobotMap.wristStraightButton);
  // public Button dPadDown = new JoystickButton(stick,RobotMap.wristDownButton);
  public Button rightTrigger = new JoystickButton(stick, RobotMap.clawOpenButton);
  public Button leftTrigger = new JoystickButton(stick, RobotMap.clawCloseButton);
  public Button aButton = new JoystickButton(stick, RobotMap.incramentIndexButton);
  public Button bButton = new JoystickButton(stick, RobotMap.decramentIndexButton);

  public OI() {
    bButton.whenPressed(new DecramentIndex());
    aButton.whenPressed(new IncramentIndex());
    // xButton.whenPressed(new MidLiftTwo());
    // yButton.whenPressed(new HighestLift());
    rightTrigger.whenPressed(new ClawOpen());
    leftTrigger.whenPressed(new ClawClose());
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
