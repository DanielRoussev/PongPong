import javax.swing.JFrame;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.lang.Math;

public class Ball {

    public Rect rect;
    public Rect leftPaddle, rightPaddle;

    private int counterR = 0;
    private int counterL = 0;

    //public String counterR = "0";
    private double vy = 0;
    private double vx = 450;

    public int zalulual = 0;

    public int getCounterR() {
        return counterR;
    }

    public int getCounterL() {
        return counterL;
    }

    public Ball(Rect rect, Rect leftPaddle, Rect rightPaddle) {
        this.rect = rect;
        this.leftPaddle = leftPaddle;
        this.rightPaddle = rightPaddle;

    }

    public double calculateNewVelocityAngle(Rect paddle) {
        double relativeIntersectY = (paddle.y + (paddle.height / 2.0)) - (this.rect.y + (this.rect.height / 2.0));
        double normalIntersectY = relativeIntersectY / (paddle.height / 2.0);
        double theta = normalIntersectY * Constants.MAX_ANGLE;

        // System.out.println(normalIntersectY);
        //System.out.println(theta);
        return Math.toRadians(theta);


    }

    public void update(double dt) {

        if (vy > 0.0) {
            if (this.rect.y + this.rect.height > Constants.SCREEN_HEIGHT - Constants.INSETS_BOTTOM) {
                this.vy *= -1.0;

            }
        } else if (vy < 0.0) {
            if (this.rect.y < Constants.TOOLBAR_HEIGHT) {
                this.vy *= -1.0;

            }
        }

        if (vx < 0.0) {
            if (this.rect.x <= this.leftPaddle.x + this.leftPaddle.width
                    && this.rect.x >= this.leftPaddle.x
                    && this.rect.y >= this.leftPaddle.y - Constants.BALL_WIDTH
                    && this.rect.y <= this.leftPaddle.y + this.leftPaddle.height

            ) {

                double theta = calculateNewVelocityAngle(leftPaddle);
                double newVx = Math.abs(Math.cos(theta)) * Constants.BALL_SPEED;
                double newVy = (-Math.sin(theta)) * Constants.BALL_SPEED;

                double oldSign = Math.signum(vx);
                this.vx = newVx * (-1.0 * oldSign);
                this.vy = newVy;
                Constants.BALL_SPEED += 20;

            }

        } else if (vx >= 0.0) {
            if (this.rect.x >= this.rightPaddle.x - this.rightPaddle.width
                    && this.rect.x <= this.rightPaddle.x
                    && this.rect.y >= this.rightPaddle.y - Constants.BALL_WIDTH
                    && this.rect.y <= this.rightPaddle.y + this.rightPaddle.height

            ) {
                double theta = calculateNewVelocityAngle(rightPaddle);
                double newVx = Math.abs(Math.cos(theta)) * Constants.BALL_SPEED;
                double newVy = (-Math.sin(theta)) * Constants.BALL_SPEED;

                double oldSign = Math.signum(vx);
                this.vx = newVx * (-1.0 * oldSign);
                this.vy = newVy;
                Constants.BALL_SPEED += 40;

                zalulual += Constants.BALL_SPEED;
            }


        }
        this.rect.x += vx * dt;
        this.rect.y += vy * dt;


        if (this.rect.x + this.rect.width < leftPaddle.x) {
            counterR++;
            System.out.println(counterL + " : " + counterR);


            this.rect.x = Constants.SCREEN_WIDTH / 2- Constants.BALL_WIDTH/2;
            this.rect.y = Constants.SCREEN_HEIGHT / 2;
            rightPaddle.y = Constants.SCREEN_HEIGHT / 2 - Constants.PADDLE_HEIGHT / 2 + Constants.BALL_WIDTH / 2;
            leftPaddle.y = Constants.SCREEN_HEIGHT / 2 - Constants.PADDLE_HEIGHT / 2 + Constants.BALL_WIDTH / 2;
            this.vx = -450 ;
            this.vy = 0;
            Constants.BALL_SPEED = 450;
            if (counterR==7) {

                this.vx = 0;


            }



        } else if (this.rect.x > rightPaddle.x + rightPaddle.width) {
            counterL++;
            System.out.println(counterL + " : " + counterR);
            this.rect.x = Constants.SCREEN_WIDTH / 2- Constants.BALL_WIDTH/2;
            this.rect.y = Constants.SCREEN_HEIGHT / 2;
            rightPaddle.y = Constants.SCREEN_HEIGHT / 2 - Constants.PADDLE_HEIGHT / 2 + Constants.BALL_WIDTH / 2;
            leftPaddle.y = Constants.SCREEN_HEIGHT / 2 - Constants.PADDLE_HEIGHT / 2 + Constants.BALL_WIDTH / 2;
            this.vx = 450;
            this.vy = 0;
            Constants.BALL_SPEED = 450;
            if (counterL==7) {
                this.vx = 0;

            }


        }


    }

}



