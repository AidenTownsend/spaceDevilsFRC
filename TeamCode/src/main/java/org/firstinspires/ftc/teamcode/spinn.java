package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Blue Side", group="Foundation")
public class spinn extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftfront = null;
    private DcMotor rightfront = null;
    private DcMotor leftrear = null;
    private DcMotor rightrear = null;
    private Servo foundationServo = null;
    long miliPerInch = (1000/(600339567/25000000));
    long miliPerDeg = (1/90);
    long c;

    public void power(double speed, long mili){
        leftfront.setPower(speed);
        rightfront.setPower(speed);
        leftrear.setPower(speed);
        rightrear.setPower(speed);
        sleep((mili));
    }
    public void turn(double speed, long time){
        c = (long)speed;
        leftfront.setPower(-speed);
        rightfront.setPower(speed);
        leftrear.setPower(-speed);
        rightrear.setPower(speed);
        sleep((time));
    }
    public void foundation(byte a){
        if (a == 0)foundationServo.setPosition(0);
        if (a == 1)foundationServo.setPosition(1);
        sleep(750);
    }

    public void driveMap(){
        runtime.reset();
        turn(1,10000);
        power(0,2000);
        turn(-1,10000);
    }
    @Override
    public void runOpMode() {
        leftfront  = hardwareMap.get(DcMotor.class, "left_front");
        rightfront = hardwareMap.get(DcMotor.class, "right_front");
        leftrear = hardwareMap.get(DcMotor.class, "left_rear");
        rightrear = hardwareMap.get(DcMotor.class, "right_rear");
        foundationServo = hardwareMap.get(Servo.class, "servo3");

        leftfront.setDirection(DcMotor.Direction.FORWARD);
        rightfront.setDirection(DcMotor.Direction.REVERSE);
        leftrear.setDirection(DcMotor.Direction.FORWARD);
        rightrear.setDirection(DcMotor.Direction.REVERSE);

        driveMap();
    }
}