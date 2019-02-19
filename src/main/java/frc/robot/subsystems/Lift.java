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
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.LowestLift;
import frc.robot.commands.SyncSlave;


public class Lift extends Subsystem{

  Victor liftmotorLeft = new Victor(RobotMap.liftmotorLeft);
  Victor liftmotorRight = new Victor(RobotMap.liftmotorRight);

  AnalogPotentiometer liftPotentiometerLeft = new AnalogPotentiometer(RobotMap.liftPotentiometerLeft, 116.5);
  AnalogPotentiometer liftPotentiometerRight = new AnalogPotentiometer(RobotMap.liftPotentiometerRight, 116.5, 2.0);

  PIDController pidLoopLeft = new PIDController(1, 0, 0, liftPotentiometerLeft, this::speedSetterLeft);
  PIDController pidLoopRight = new PIDController(1, 0, 0, liftPotentiometerRight, this::speedSetterRight, 0.02);

  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public Lift() {
    LiveWindow.addActuator("LiftMaster", "motor", liftmotorLeft);
    LiveWindow.addSensor("LiftMaster", "pot", liftPotentiometerLeft);
    LiveWindow.addActuator("LiftMaster", "PID Controller", pidLoopLeft);
    LiveWindow.addActuator("LiftSlave", "motor", liftmotorRight);
    LiveWindow.addSensor("LiftSlave", "pot", liftPotentiometerRight);
    LiveWindow.addActuator("LiftSlave", "PID Controller", pidLoopRight);

    pidLoopLeft.setSetpoint(RobotMap.lowestSetPoint);
    pidLoopRight.setSetpoint(liftPotentiometerLeft.get());
    pidLoopLeft.enable();
    pidLoopRight.enable();
  }

  public void lowestLift(){
    pidLoopLeft.setSetpoint(RobotMap.lowestSetPoint);
    syncSlave();

  }

  public void midLiftOne(){
    pidLoopLeft.setSetpoint(RobotMap.midSetPointOne);
    syncSlave();
  }

  public void midLiftTwo(){
    pidLoopLeft.setSetpoint(RobotMap.midSetPointTwo);
    syncSlave();
  }

  public void highestLift(){
    pidLoopLeft.setSetpoint(RobotMap.highestSetPoint);
    syncSlave();
  }

  public void syncSlave(){
    pidLoopRight.setSetpoint(liftPotentiometerLeft.get());
  }

  public double setSmartDashboardLeft(){
   return liftPotentiometerLeft.get();
  }
  public double setSmartDashboardRight(){
    return liftPotentiometerRight.get();
  }

  public void smartDashboardOutput(){
    SmartDashboard.putData("Left", pidLoopLeft);
  }

  public void smartDashBoardOutputRight(){
    SmartDashboard.putData("Right", pidLoopRight);
  }

  

  public void stop(){
    liftmotorLeft.set(0.0);
    liftmotorRight.set(0.0);
  }

  private void speedSetterLeft(double output){
    if (output > 0.6) {
      liftmotorLeft.set(0.6);
    } else if (output < -0.6) {
      liftmotorLeft.set(-0.6);
    }
    else {
      if(Math.abs(pidLoopLeft.getError()) < RobotMap.masterTolerance) {
        liftmotorLeft.set(0.0);
      } else {
        liftmotorLeft.set(output);
    }
  }

  private void speedSetterRight(double output){
    if (output > 0.6) {
      liftmotorRight.set(0.6);
    } else if (output < -0.6){
      liftmotorRight.set(-0.6);
    }
    else{
      if(Math.abs(pidLoopRight.getError()) < RobotMap.slaveTolerance) {
        liftmotorRight.set(0.0);
      } else {
        liftmotorRight.set(output);
      }
    }
    syncSlave();
  }

  @Override
  public void initDefaultCommand() {
    // setDefaultCommand(new SyncSlave());
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
