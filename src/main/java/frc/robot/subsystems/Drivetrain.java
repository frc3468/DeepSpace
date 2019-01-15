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

  Victor motordtFrontRight = new Victor(RobotMap.dtFrontRight);
  Victor motordtRearRight = new Victor(RobotMap.dtRearRight);
  SpeedControllerGroup rightMotors = new SpeedControllerGroup(motordtFrontRight, motordtRearRight);

  Victor motordtFrontLeft = new Victor(RobotMap.dtmotorFrontLeft);
  Victor motordtRearLeft = new Victor(RobotMap.dtmotorRearLeft);
  SpeedControllerGroup leftMotors = new SpeedControllerGroup(motordtFrontLeft, motordtRearLeft);

  DifferentialDrive RobotDrive = new DifferentialDrive(leftMotors, rightMotors);


  public void Halodrive(double magnitude, double rotation) {

    rotation = map(rotation, -1.0, 1.0, -0.8, 0.8);
    RobotDrive.arcadeDrive(magnitude, rotation);


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









