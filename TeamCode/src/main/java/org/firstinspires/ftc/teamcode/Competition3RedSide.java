package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Run this auto for red side", group="Competition.3")
public class Competition3RedSide extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftfront = null;
    private DcMotor rightfront = null;
    private DcMotor leftrear = null;
    private DcMotor rightrear = null;
    private Servo foundationServo = null;

    public void power(double speed, int length){
        leftfront.setPower(speed);
        rightfront.setPower(speed);
        leftrear.setPower(speed);
        rightrear.setPower(speed);
        sleep(length);
    }

    public void turn(double speed, int length){
        leftfront.setPower(speed);
        rightfront.setPower(-speed);
        leftrear.setPower(speed);
        rightrear.setPower(-speed);
        sleep(length);
    }

    public void strafe (double speed, int time)   {
        leftfront.setPower(speed);
        rightrear.setPower(speed*.5);
        leftrear.setPower(-speed*.5);
        rightfront.setPower(-speed);
        sleep(time);
    }

    public void Path(){
        runtime.reset();
        strafe(-1,800);
        power(1, 1400);
        power(0, 500);
        foundationServo.setPosition(.5);
        sleep(500);
        power(-0.5, 5000);
        foundationServo.setPosition(0);
        power(0, 500);
        sleep(1000);
        strafe(1, 2000);
        power(1, 700);
        strafe(-1, 1000);
        strafe(1, 1700);
    }

    @Override
    public void runOpMode() {
        leftfront  = hardwareMap.get(DcMotor.class, "left_front");
        rightfront = hardwareMap.get(DcMotor.class, "right_front");
        leftrear = hardwareMap.get(DcMotor.class, "left_rear");
        rightrear = hardwareMap.get(DcMotor.class, "right_rear");
        foundationServo = hardwareMap.get(Servo.class, "servof");

        leftfront.setDirection(DcMotor.Direction.REVERSE);
        rightfront.setDirection(DcMotor.Direction.FORWARD);
        leftrear.setDirection(DcMotor.Direction.REVERSE);
        rightrear.setDirection(DcMotor.Direction.FORWARD);

        leftfront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightfront.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        leftrear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        rightrear.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Path();
    }
}