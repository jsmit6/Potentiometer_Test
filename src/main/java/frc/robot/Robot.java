/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This is a sample program to demonstrate how to use a soft potentiometer and a
 * PID controller to reach and maintain position setpoints on an elevator
 * mechanism.
 */
public class Robot extends TimedRobot {

  // POTENTIOMETER TEST
   private Potentiometer p1 = new AnalogPotentiometer(0);
  private boolean middle = false;
  private boolean maxed = false;
  private boolean minned = false;

  @Override
  public void robotInit() {

  }

  @Override
  public void teleopInit() {

  }

  @Override
  public void teleopPeriodic() {

    // POTENTIOMETER TEST
    int pid = (int) (p1.get() * 100);
    if (pid < 21) {
      System.out.println("Arm is completely lowered");
      middle = false;
      maxed = false;
      minned = true;
    } else if (pid > 60) {
      System.out.println("Arm is completely Lifted");
      middle = false;
      maxed = true;
      minned = false;
    } else if (!middle && pid > 21 && pid < 60) {
      middle = true;
      maxed = false;
      minned = false;
      System.out.println("Arm in the middle");
    } 
  }
}
