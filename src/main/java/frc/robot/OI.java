/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.commands.TransferToForward;
import frc.robot.commands.VacuumOn;
import frc.robot.commands.TransferToBack;
import frc.robot.commands.Climb;
import frc.robot.commands.LiftDown;
import frc.robot.commands.LiftSwitch;
//import frc.robot.commands.TestSequencer;
import frc.robot.commands.LiftScale;
//import frc.robot.commands.LiftSetpoint;
import frc.robot.commands.LiftHook;
import frc.robot.commands.LiftManualMove;
import frc.robot.commands.LiftRobot;   // same as lift down, but may be partial


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private Joystick m_joystick = new Joystick(0);

	private JoystickButton trigger;
	private JoystickButton thumb;
	
	// Top buttons (counterclockwise from top left: 5-3-4-6)
	private JoystickButton button5;
	private JoystickButton button3;
	private JoystickButton liftManualDown;
	private JoystickButton liftManualUp;
		
	// Side buttons (from top left)
	private JoystickButton button7;
	private JoystickButton button8;
	private JoystickButton button9;
	private JoystickButton button10;
	private JoystickButton button11;
	private JoystickButton button12;
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	public OI() {
		// Put our operations buttons on the SmartDashboard
		
		SmartDashboard.putData("Transfer to Forward", new TransferToBack());
		SmartDashboard.putData("Transfer to Back", new TransferToForward());
	
		
		SmartDashboard.putData("Lift Down", new LiftDown());
		SmartDashboard.putData("Lift Switch", new LiftSwitch());
		SmartDashboard.putData("Lift Scale", new LiftScale());
		SmartDashboard.putData("Lift Hook", new LiftHook());
		SmartDashboard.putData("Lift Robot", new LiftRobot());
		SmartDashboard.putData("Vacuum", new VacuumOn());
		
		// BUTTON MAPPINGS
		trigger = new JoystickButton(m_joystick, 1);
		thumb = new JoystickButton(m_joystick, 2);
		
		// Top buttons (counterclockwise from top left: 5-3-4-6)
		button5 = new JoystickButton(m_joystick, 5);
		button3 = new JoystickButton(m_joystick, 3);
		liftManualDown= new JoystickButton(m_joystick, 4);
		liftManualUp = new JoystickButton(m_joystick, 6);
		
		// Side buttons (from top left)
		button7 = new JoystickButton(m_joystick, 7);
		button8 = new JoystickButton(m_joystick, 8);
		button9 = new JoystickButton(m_joystick, 9);
		button10 = new JoystickButton(m_joystick, 10);
		button11 = new JoystickButton(m_joystick, 11);
		button12 = new JoystickButton(m_joystick, 12);
		
		
		
		// COMMAND MAPPINGS
		trigger.whileHeld(new VacuumOn());
		thumb.whileHeld(new Climb());
		
		// TODO for testing purposes
		button3.toggleWhenPressed(new TransferToBack());
		button5.toggleWhenPressed(new TransferToForward());
		liftManualDown.whileHeld(new LiftManualMove(-1, 0.5));
		liftManualUp.whileHeld(new LiftManualMove(1, 0.50));
		
		
		// TODO change mappings depending on the driver's preferences
		button7.whenPressed(new LiftDown());

		button9.whenPressed(new LiftSwitch());

		button10.whenPressed(new LiftScale());
		button11.whenPressed(new LiftHook());
		button12.whenPressed(new LiftRobot());
	}
	
	public Joystick getJoystick() {
		return m_joystick;
	}
}
