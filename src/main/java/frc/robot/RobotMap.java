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
  
// Controller and Buttons--------------------
  public static int xboxcontroller = 0;
  public static int clawCloseButton = 5;
  public static int clawOpenButton = 6;
  public static int incramentIndexButton = 1;
  public static int decramentIndexButton = 2;
  public static int incramentSetPointButton = 3;
  public static int decramentSetPointButton = 4;

// Drivetrain Motors-------------------------
  public static int dtmotorFrontRight = 0;
  public static int dtmotorRearRight = 1;
  public static int dtmotorFrontLeft = 2;
  public static int dtmotorRearLeft = 3;

// Lift Motors-------------------------------
  public static int liftmotorLeft = 4;
  public static int liftmotorRight = 5;

// Wrist Motor-------------------------------
  public static int wristMotor = 6;

// Wrist Counter-----------------------------
  public static int wristCounter = 0;

// Lift Potentiometers-----------------------
  public static int liftPotentiometerLeft = 0;
  public static int liftPotentiometerRight = 1;

// Variables for Lift Commands---------------
  public static double lowestSetPoint = 12.0;
  public static double midSetPointOne = 34.0;
  public static double midSetPointTwo = 60.0;
  public static double highestSetPoint = 88.0;
  public static double masterTolerance = 0.50; // Tolerance in "inches"
  public static double slaveTolerance = 0.10; // Tolerance in "inches"

// Servo Motor
  public static int clawServo = 7;
  
// Lift Array
  public static double[] liftArray = new double[]{19.0, 34.0, 50.0, 60.0, 80.0, 88.0};




  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
