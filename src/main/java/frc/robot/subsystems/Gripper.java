package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gripper extends Subsystem {
    private SpeedController motor;
    private DigitalInput limitSwitch;
    public static final double IN_SPEED = -0.7;
    public static final double OUT_SPEED = 0.7;

    public Gripper(SpeedController motor, DigitalInput limitSwitch) {
        this.motor = motor;
        this.limitSwitch = limitSwitch;
    }

    public void push() {
        motor.set(OUT_SPEED);
    }

    public void pull() {
        motor.set(IN_SPEED);
    }

    public DigitalInput getLimitSwitch() {
        return limitSwitch;
    }

    public void stop() {
        motor.stopMotor();
    }

    @Override
    protected void initDefaultCommand() {

    }
}
