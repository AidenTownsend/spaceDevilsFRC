package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous (name="Red Side", group="Foundation")
public class redFoundation extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftfront = null;
    private DcMotor rightfront = null;
    private DcMotor leftrear = null;
    private DcMotor rightrear = null;
    private Servo foundationServo = null;
    long a = 1000*(1/((3/2)*12));
    long b = (1/180);

    public void power(double speed, long time){
        leftfront.setPower(speed);
        rightfront.setPower(speed);
        leftrear.setPower(speed);
        rightrear.setPower(speed);
        sleep(time*a);
    }
    public void turn(double speed, long degrees){
        leftfront.setPower(-speed);
        rightfront.setPower(speed);
        leftrear.setPower(-speed);
        rightrear.setPower(speed);
        sleep(degrees*b);
    }
    public void foundation(byte a){
        if (a == 0)foundationServo.setPosition(0);
        if (a == 1)foundationServo.setPosition(1);
        sleep(500);
    }

    public void driveMap(){
        runtime.reset();
        foundation((byte)0);
        power(1, 30);//1
        power(0.5, 2);//2
        power(0, (1/10));//3
        foundation((byte)1);
        power(-1, 15);//4
        power(0,0);
        foundation((byte)0);
        power(-1, 2);//5
        turn(1, 90);//6
        power(1, 30);//7
        turn(-1,90);//8
        power(1,(69/2));//9
        turn(-1, 90);//10
        power(1,30);//11
        turn(-1,90);//12
        power(1,33);//13
        power(-0.5, 2);//14
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
