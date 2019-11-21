package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "movrs forward at ful power for 3/4 of a second", group = "Bridge")
public class oneSecondAuto extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftfront = null;
    private DcMotor rightfront = null;
    private DcMotor leftrear = null;
    private DcMotor rightrear = null;
    private Servo foundationServo = null;
    boolean stop = false;

    public void power(double speed, int length) {
        leftfront.setPower(speed);
        rightfront.setPower(speed);
        leftrear.setPower(speed);
        rightrear.setPower(speed);
        sleep(length);
    }

    public void turn(double speed, int length) {
        leftfront.setPower(speed);
        rightfront.setPower(-speed);
        leftrear.setPower(speed);
        rightrear.setPower(-speed);
        sleep(length);
    }

    public void strafe(double speed, int time) {
        leftfront.setPower(speed);
        rightrear.setPower(speed * .5);
        leftrear.setPower(-speed * .5);
        rightfront.setPower(-speed);
        sleep(time);
    }

    public void Path() {
        runtime.reset();
        power(1,750);
    }

    @Override
    public void runOpMode() {
        leftfront = hardwareMap.get(DcMotor.class, "left_front");
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

        while (opModeIsActive()){
            if (!stop){
                Path();
                stop = true;
            }
        }

    }
}