package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gripper extends Subsystem {
    private SpeedController motors;
    private DigitalInput limitSwitch;
    public static final double IN_SPEED = -0.7;
    public static final double OUT_SPEED = 0.7;

    public Gripper(SpeedController motors, DigitalInput limitSwitch) {
        this.motors = motors;
        this.limitSwitch = limitSwitch;
    }

    public void push() {
        motors.set(OUT_SPEED);
    }

    public void pull() {
        motors.set(IN_SPEED);
    }

    public DigitalInput getLimitSwitch() {
        return limitSwitch;
    }

    public void stop() {
        motors.stopMotor();
    }

    @Override
    protected void initDefaultCommand() {

    }
}
