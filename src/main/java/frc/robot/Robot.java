/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Gripper;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
    public static OI oi;
    public static Gripper gripper;
    public static DriveTrain driveTrain;
    private SpeedController gripperMotorRight;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    @Override;
    public void robotInit() {
        gripperMotorRight = new WPI_TalonSRX(RobotMap.PWM.GRIPPER_MOTOR_RIGHT);
        gripperMotorRight.setInverted(false);
        gripper = new Gripper(new SpeedControllerGroup(gripperMotorRight, new WPI_VictorSPX(RobotMap.PWM.GRIPPER_MOTOR_LEFT)), new DigitalInput(RobotMap.DIO.GRIPPER_LIMIT_SWITCH));
        driveTrain = new DriveTrain(new SpeedControllerGroup(new VictorSP(RobotMap.CAN.DRIVE_TRAIN_LEFT_FRONT), new VictorSP(RobotMap.CAN.DRIVE_TRAIN_LEFT_BACK)), new SpeedControllerGroup(new VictorSP(RobotMap.CAN.DRIVE_TRAIN_RIGHT_FRONT), new VictorSP(RobotMap.CAN.DRIVE_TRAIN_RIGHT_BACK)));
        oi = new OI();


    }

    /**
     * This function is called every robot packet, no matter the mode. Use
     * this for items like diagnostics that you want ran during disabled,
     * autonomous, teleoperated and test.
     *
     * <p>This runs after the mode specific periodic functions, but before
     * LiveWindow and SmartDashboard integrated updating.
     */
    @Override
    public void robotPeriodic() {
    }

    /**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
     * the robot is disabled.
     */
    @Override
    public void disabledInit() {
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This autonomous (along with the chooser code above) shows how to select
     * between different autonomous modes using the dashboard. The sendable
     * chooser code works with the Java SmartDashboard. If you prefer the
     * LabVIEW Dashboard, remove all of the chooser code and uncomment the
     * getString code to get the auto name from the text box below the Gyro
     *
     * <p>You can add additional auto modes by adding additional commands to the
     * chooser code above (like the commented example) or additional comparisons
     * to the switch structure below with additional strings & commands.
     */
    @Override
    public void autonomousInit() {

    }

    /**
     * This function is called periodically during autonomous.
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {

    }

    /**
     * This function is called periodically during operator control.
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }

    /**
     * This function is called periodically during test mode.
     */
    @Override
    public void testPeriodic() {
    }
}
