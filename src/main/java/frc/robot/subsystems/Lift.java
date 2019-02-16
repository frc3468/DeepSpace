/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Lift extends PIDSubsystem {

  //Lift Motors
  Victor liftMotorLeft = new Victor(RobotMap.liftMotorLeft);
  Victor liftMotorRight = new Victor(RobotMap.liftMotorRight);
  SpeedControllerGroup liftMotors = new SpeedControllerGroup(liftMotorLeft, liftMotorRight);

  //Lift Potentiometers
  AnalogPotentiometer liftPotentiometerLeft = new AnalogPotentiometer(RobotMap.liftPotentiometerLeft);
  AnalogPotentiometer liftPotentiometerRight = new AnalogPotentiometer(RobotMap.liftPotentiometerRight);
  
  
  public Lift() {
    // Intert a subsystem name and PID values here
    super("Lift", 1, 2, 3);
    setSetpoint(0.0);
    enable();
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  @Override
  protected double returnPIDInput() {

  liftPotentiometerLeft.get();
  liftPotentiometerRight.get();
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
    return 0.0;
  }

  @Override
  protected void usePIDOutput(double output) {
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
  }
}
