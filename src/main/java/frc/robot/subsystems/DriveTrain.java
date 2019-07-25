package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.commands.DriveTrainMove;

public class DriveTrain extends Subsystem {
    private SpeedController left;
    private SpeedController right;

    public DriveTrain(SpeedController left, SpeedController right) {
        this.left = left;
        this.right = right;
    }

    public void moveTank(double leftSpeed, double rightSpeed) {
        left.set(leftSpeed);
        right.set(rightSpeed);

    }
    public void stop(){
        left.stopMotor();
        right.stopMotor();
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new DriveTrainMove(Robot.oi::getLeftY, Robot.oi::getRightY));
    }
}
