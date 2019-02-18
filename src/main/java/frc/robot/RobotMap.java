/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  // Controller and Buttons
  public static int xboxcontroller = 0;
  public static int lowestLiftButton = 1;
  public static int midLiftOneButton = 2;
  public static int midLiftTwoButton = 3;
  public static int highestLiftButton = 4;
  
  public static int clawCloseButton = 6;
  public static int clawOpenButton = 7;
  
  // Drivetrain Motors-------------------------
  public static int dtmotorFrontRight = 0;
  public static int dtmotorRearRight = 1;
  public static int dtmotorFrontLeft = 2;
  public static int dtmotorRearLeft = 3;

  // Lift Motors-------------------------------
  public static int liftmotorLeft = 4;
  public static int liftmotorRight = 5;

  // Lift Potentiometers-----------------------
  public static int liftPotentiometerLeft = 6;
  public static int liftPotentiometerRight = 7;

  // Variables for Lift Commands---------------
  public static double lowestSetPoint = 0.1;
  public static double midSetPointOne = 0.3;
  public static double midSetPointTwo = 0.5;
  public static double highestSetPoint = 0.7;

  // Servo Motor
  public static int clawServo = 7;




  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
