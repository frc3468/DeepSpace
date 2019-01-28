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
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.LowerLift;

/**
 * Add your docs here.
 */
public class RobotLift extends Subsystem {

  Victor motorliftLower = new Victor(RobotMap.liftLower);
  Victor motorliftUpper = new Victor(RobotMap.liftUpper);
  SpeedControllerGroup liftMotors= new SpeedControllerGroup(motorliftLower, motorliftUpper);


  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public RobotLift() {
    motorliftUpper.setInverted(true);

  }
  public void Lift(){
    liftMotors.set(0.8);
  }
  public void LowerLift(){
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
