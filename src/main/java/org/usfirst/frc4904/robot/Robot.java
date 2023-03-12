/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc4904.robot;

import java.util.Timer;
import java.util.TimerTask;

import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.robot.humaninterface.operators.DefaultOperator;
import org.usfirst.frc4904.standard.CommandRobotBase;

import edu.wpi.first.math.controller.DifferentialDriveWheelVoltages;
import edu.wpi.first.math.kinematics.ChassisSpeeds;


// TODO implement test and sim in CommandRobotBase
public class Robot extends CommandRobotBase {
    private static RobotMap map = new RobotMap();

    @Override
    public void initialize() {
        driverChooser.setDefaultOption(new NathanGain());
        operatorChooser.setDefaultOption(new DefaultOperator());
        // autoChooser.setDefaultOption(RobotMap.Autonomous.autonCommand);  // zach is worried that this will get misclicked -> screw us
    }

    @Override
    public void teleopInitialize() {
    }

    @Override
    public void teleopExecute() {
    }

    @Override
    public void autonomousInitialize() {
        // TODO: remove; for testing only
        RobotMap.Component.leftDriveMotors.setBrakeOnNeutral();
        RobotMap.Component.rightDriveMotors.setBrakeOnNeutral();

        RobotMap.Autonomous.autonCommand.schedule();    // or use this.autoChooser.addOption() for smartDashboard auton chooser?
    }

    @Override
    public void autonomousExecute() {
    }

    @Override
    public void disabledInitialize() {
        // TODO: remove; for testing only
        new Timer().schedule(new TimerTask() { // https://stackoverflow.com/a/56225206/10372825
            public void run() {
                RobotMap.Component.leftDriveMotors.coast();
                RobotMap.Component.rightDriveMotors.coast();
            }
        }, 2 * 1000L);  // coast motors after 2 seconds
    }

    @Override
    public void disabledExecute() {
    }

    @Override
    public void testInitialize() {
        RobotMap.Component.chassis.setChassisVelocity(new ChassisSpeeds(0, 0, 1));
        // RobotMap.Component.chassis.setWheelVoltages(new DifferentialDriveWheelVoltages(3, 3));
        //robot jerks around when trying to go forward
        //robot stopped responding even w/ green code light
    }

    @Override
    public void testExecute() {
    }

    @Override
    public void alwaysExecute() {
    }

}
