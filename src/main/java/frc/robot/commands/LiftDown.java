package frc.robot.commands;

import frc.robot.Robot;

//import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class LiftDown extends LiftSetpoint {

	// set negative and let limit switch set 0 AND reset the lift position
	private static final double downpos = -100;		// negative

    public LiftDown() {    	
    	super(downpos);
    	
    	requires(Robot.m_Lift);
    }
}

