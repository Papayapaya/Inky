package org.usfirst.frc4904.robot.humaninterface.drivers;

import org.usfirst.frc4904.standard.humaninput.Driver;
import org.usfirst.frc4904.robot.RobotMap;


public class SwerveGain extends Driver{ //ALL SWERVEGAIN JOYSTICKS OUTPUT FROM -1 TO 1
    
    double SPEED_EXP = 2; //TODO TUNE
    double TURN_EXP = 2; //TODO TUNE




    public SwerveGain(){
        super("SwerveGain");
    }

    protected double scaleGain(double input, double exp) {
		return Math.pow(Math.abs(input), exp) * Math.signum(input);
	}

    public void bindCommands(){
        
    }
    public double getX(){
        double raw = RobotMap.HumanInput.Driver.xyJoystick.getX();
        return scaleGain(raw, SPEED_EXP);
    }
    public double getY(){
        double raw = RobotMap.HumanInput.Driver.xyJoystick.getY();
        return scaleGain(raw, SPEED_EXP);
    }
    public double getTurnSpeed(){
        double raw = RobotMap.HumanInput.Driver.turnJoystick.getX();
        return scaleGain(raw, TURN_EXP);
    }


}
