/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import frc.robot.RobotMap;
import frc.robot.commands.WristPOV;

/**
 * Add your docs here.
 */
public class Wrist extends PIDSubsystem {

// Wrist Motor---------------------------------  
  Victor wristMotor = new Victor(RobotMap.wristMotor);

// Wrist Counter-------------------------------  
  Counter wristCounter = new Counter(RobotMap.wristCounter);

  /**
   * Add your docs here.
   */
  public Wrist() {
    // Intert a subsystem name and PID values here
    super("Wrist", 1, 2, 3);
    setSetpoint(0);
    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
  }

// Setting Wrist Speeds------------------------  
  public void up() {
    wristMotor.set(-0.6);
  }

  public void down() {
    wristMotor.set(0.6);
  }

  public void stop() {
    wristMotor.set(0.0);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new WristPOV());
  }

  @Override
  protected double returnPIDInput() {
    return wristCounter.get()*(360/174.9);
    
    // Return your input value for the PID loop
    // e.g. a sensor, like a potentiometer:
    // yourPot.getAverageVoltage() / kYourMaxVoltage;
  }

  @Override
  protected void usePIDOutput(double output) {
    wristMotor.set(output);
    // Use output to drive your system, like a motor
    // e.g. yourMotor.set(output);
  }
}
