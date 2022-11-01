// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private CANSparkMax leftFront, leftRear, rightFront, rightRear;

  private Joystick leftStick, rightStick;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    //Declare the two joysticks
    leftStick = new Joystick(0);  
    //0 is the computer USB port for joystick1, as seen on driver's station tab
    rightStick = new Joystick(1); 
    //1 is the computer USB port for joystick2, as seen on driver's station

    // Initialize motor controllers using their ID numbers
    leftFront = new CANSparkMax(30, MotorType.kBrushless); //30 is the SparkMax ID#
    leftRear = new CANSparkMax(44, MotorType.kBrushless); //44 is the SparkMax ID# 
    rightFront = new CANSparkMax(43, MotorType.kBrushless); //43 is the SparkMax ID#
    rightRear = new CANSparkMax(45, MotorType.kBrushless); //45 is the SparkMax ID#
 
    // Set right front controller to be inverted
    leftFront.setInverted(false);
    rightFront.setInverted(true);

    // Set rear controllers to follow front
    leftRear.follow(leftFront);
    rightRear.follow(rightFront);
  }
  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}


  @Override
  public void autonomousInit() {}


  /** This function is called periodically during autonomous. */
  public void autonomoousPeriodic() {}

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    //Set front drive motors speed according to the Y axes on the two joysticks (Tank Drive)
    leftFront.set(-leftStick.getY());
    rightFront.set(-rightStick.getY());
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {
    leftFront.set(0);
    rightFront.set(0);
  }

}
  

