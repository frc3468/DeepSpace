/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem {
   Servo clawServo = new Servo(RobotMap.clawServo);


  // Put methods for controlling this subsystem
  // here. Call these from Commands.


// Claw Commands-------------------------------  
  public void clawServoOpen() {
    clawServo.set(0.3);
    
  }

  public void clawServoClose() {
    clawServo.set(0.6);
  }

  public double smartDashboardClaw(){
    return clawServo.get();
  }
  
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
