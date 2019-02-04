/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;


public class Lift extends Subsystem {

  Victor liftmotor = new Victor(RobotMap.liftmotor);


  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Lift() {

  }

  
  public void raiseLift(){
    liftmotor.set(0.8);
  }
  

  public void lowerLift(){
    liftmotor.set(0.5);
  }
  

  public void stop(){
    liftmotor.set(0.0);
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
