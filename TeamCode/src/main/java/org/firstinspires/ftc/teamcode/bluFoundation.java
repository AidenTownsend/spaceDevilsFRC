package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Blue Side", group="Foundation")
public class bluFoundation extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftfront = null;
    private DcMotor rightfront = null;
    private DcMotor leftrear = null;
    private DcMotor rightrear = null;
    private Servo foundationServo = null;
    long miliPerInch = (1000/(600339567/25000000));
    long miliPerDeg = (1/90);
    long c;

    public void power(double speed, long inches){
        if(speed != 0) {
            c = (long) speed;
            leftfront.setPower(speed);
            rightfront.setPower(speed);
            leftrear.setPower(speed);
            rightrear.setPower(speed);
            sleep((inches * miliPerInch) / c);
        }else{
            leftfront.setPower(speed);
            rightfront.setPower(speed);
            leftrear.setPower(speed);
            rightrear.setPower(speed);
            sleep(inches*1000);
        }
    }
    public void turn(double speed, long degrees){
        c = (long)speed;
        leftfront.setPower(speed);
        rightfront.setPower(-speed);
        leftrear.setPower(speed);
        rightrear.setPower(-speed);
        sleep((degrees*miliPerDeg)/c);
    }
    public void foundation(byte a){
        if (a == 0)foundationServo.setPosition(0);
        if (a == 1)foundationServo.setPosition(1);
        sleep(750);
    }

    public void driveMap(){
        runtime.reset();
        foundation((byte)0);
        power(1, 30);//1
        power(0.5, 1);//2
        power(0, (1/10));//3
        foundation((byte)1);
        power(-1, 15);//4
        power(0,0);
        foundation((byte)0);
        power(-1, 1);//5
        turn(1, 90);//6
        power(1, 30);//7
        turn(-1,90);//8
        power(1,(68/72));//9
        turn(-1, 90);//10
        power(1,30);//11
        turn(-1,90);//12
        power(1,33);//13
        power(-0.5, 1);//14
        turn(-1,90);//15
        power(1,60);//16
        leftfront.setPower(0);
        rightfront.setPower(0);
        leftrear.setPower(0);
        rightrear.setPower(0);
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