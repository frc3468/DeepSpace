/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;


import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.LowestLift;


public class Lift extends Subsystem{

  Victor liftmotorLeft = new Victor(RobotMap.liftmotorLeft);
  Victor liftmotorRight = new Victor(RobotMap.liftmotorRight);
  SpeedControllerGroup liftMotors = new SpeedControllerGroup(liftmotorLeft, liftmotorRight);

  AnalogPotentiometer liftPotentiometerLeft = new AnalogPotentiometer(RobotMap.liftPotentiometerLeft);
  AnalogPotentiometer liftPotentiometerRight = new AnalogPotentiometer(RobotMap.liftPotentiometerRight);

  PIDController pidLoopLeft = new PIDController(5, 3, 0, liftPotentiometerLeft, liftmotorLeft);
  PIDController pidLoopRight = new PIDController(5, 3, 0, liftPotentiometerRight, liftmotorRight);



  

  
  
  


  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Lift() {
   pidLoopLeft.setSetpoint(RobotMap.lowestSetPoint);
   pidLoopRight.setSetpoint(RobotMap.lowestSetPoint);
  }

  public void LowestLift(){
    pidLoopLeft.setSetpoint(RobotMap.lowestSetPoint);
    pidLoopRight.setSetpoint(RobotMap.lowestSetPoint);

  }

  public void MidLiftOne(){
    pidLoopLeft.setSetpoint(RobotMap.midSetPointOne);
    pidLoopRight.setSetpoint(RobotMap.midSetPointOne);
  }

  public void MidLiftTwo(){
    pidLoopLeft.setSetpoint(RobotMap.midSetPointTwo);
    pidLoopRight.setSetpoint(RobotMap.midSetPointTwo);
  }

  public void HighestLift(){
    pidLoopLeft.setSetpoint(RobotMap.highestSetPoint);
    pidLoopRight.setSetpoint(RobotMap.highestSetPoint);
  }
  public void raiseLift(){
    liftMotors.set(0.8);
  }
  

  public void lowerLift(){
    liftMotors.set(0.5);
  }
  

  public void stop(){
    liftMotors.set(0.0);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
