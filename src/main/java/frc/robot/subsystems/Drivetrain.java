/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Halodrive;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {

// Drivetrain Motors---------------------------  
  Victor dtmotorFrontRight = new Victor(RobotMap.dtmotorFrontRight);
  Victor dtmotorRearRight = new Victor(RobotMap.dtmotorRearRight);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(dtmotorFrontRight, dtmotorRearRight);

  Victor dtmotorFrontLeft = new Victor(RobotMap.dtmotorFrontLeft);
  Victor dtmotorRearLeft = new Victor(RobotMap.dtmotorRearLeft);
  SpeedControllerGroup leftMotors = new SpeedControllerGroup(dtmotorFrontLeft, dtmotorRearLeft);

  DifferentialDrive RobotDrive = new DifferentialDrive(leftMotors, rightMotors);

  


  public void Halodrive(double magnitude, double rotation) {
    magnitude = map(magnitude, -1.0, 1.0, -0.7, 0.7);
    rotation = map(rotation, -1.0, 1.0, -0.6, 0.6);
    
    RobotDrive.arcadeDrive(magnitude, rotation);



  }

  public void fixVeer(){
    if (leftMotors.get() < 0.0) {
      leftMotors.set(leftMotors.get() - 0.05);
    } else if (leftMotors.get() > 0.0) {
      leftMotors.set(leftMotors.get() + 0.05);
    }
  }

  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  @Override
  public void initDefaultCommand() {


    setDefaultCommand(new Halodrive());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  private double map(double x, double in_min, double in_max, double out_min, double out_max) {

    return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
  } 
}









