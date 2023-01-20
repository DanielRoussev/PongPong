import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements Runnable {

    public Graphics2D g2;
    public KL keyListener = new KL();
    public Rect playerOne, playerTwo, ballRect;
    public Ball ball;
    public PlayerController playerController;
    public PlayerControllerTwo playerControllerTwo;


    //public String counterR;










    public Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        Constants.TOOLBAR_HEIGHT = this.getInsets().top;
        Constants.INSETS_BOTTOM = this.getInsets().bottom;
        g2 = (Graphics2D) this.getGraphics();


        //leftScoreText = new Text(0,
                //new Font("Dialog",Font.PLAIN,Constants.TEXT_SIZE),(Constants.SCREEN_WIDTH/2)-40,Constants.TOOLBAR_HEIGHT +20);
       //rightScoreText= new Text(0,
                //new Font("Dialog",Font.PLAIN,Constants.TEXT_SIZE),(Constants.SCREEN_WIDTH/2)+7.5,Constants.TOOLBAR_HEIGHT +20);



        playerOne = new Rect(Constants.PADDLE_SPACING,Constants.SCREEN_HEIGHT/2 - Constants.PADDLE_HEIGHT/2 + Constants.BALL_WIDTH/2,Constants.PADDLE_WIDTH,Constants.PADDLE_HEIGHT,Constants.PADDLE_COLOR);

        playerController= new PlayerController(playerOne,keyListener);
        playerTwo = new Rect(Constants.SCREEN_WIDTH - Constants.PADDLE_WIDTH- Constants.PADDLE_SPACING,Constants.SCREEN_HEIGHT/2 - Constants.PADDLE_HEIGHT/2 + Constants.BALL_WIDTH/2,Constants.PADDLE_WIDTH,Constants.PADDLE_HEIGHT,Constants.PADDLE_COLOR);
        playerControllerTwo = new PlayerControllerTwo(playerTwo,keyListener);
        ballRect = new Rect(Constants.SCREEN_WIDTH/2-Constants.BALL_WIDTH/2,Constants.SCREEN_HEIGHT/2,Constants.BALL_WIDTH,Constants.BALL_WIDTH,Constants.PADDLE_COLOR);

        ball = new Ball(ballRect, playerOne, playerTwo);

        //counterRight= new String();





    }

    public void update(double dt) {
        Image dbImage = createImage(getWidth(),getHeight());
        Graphics dbg = dbImage.getGraphics();
        this.draw(dbg);
        g2.drawImage(dbImage,0,0,this);



        //System.out.println("" + dt + " seconds passed since last frame ");
        //System.out.println(1 / dt + " fps");


        playerController.update(dt);
        playerControllerTwo.update(dt);
        ball.update(dt);
        //g2.drawString("1",(Constants.SCREEN_WIDTH/2)-40,Constants.TOOLBAR_HEIGHT +20);
        //g2.drawString(counterR,(Constants.SCREEN_WIDTH/2)-40,Constants.TOOLBAR_HEIGHT +20);


    }

    public void draw(Graphics g){
        Graphics2D g2 =(Graphics2D)g;
        g2.setColor(Color.BLACK);
        g2.fillRect(0,0,Constants.SCREEN_WIDTH,Constants.SCREEN_HEIGHT);
        g2.setColor(Color.DARK_GRAY);
        for(int i=0;i <=700;i+=40){
            g2.setColor(Color.DARK_GRAY);
            g2.drawRect(345, Constants.TOOLBAR_HEIGHT+i, 10, 17);
            //g2.setColor(Color.WHITE);
            //g2.fillRect(346, Constants.TOOLBAR_HEIGHT+i+1, 9, 16);



        }
        //rechts
        g2.setColor(Color.WHITE);
        g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,10,50);
        g2.fillRect((Constants.SCREEN_WIDTH/2)+30,Constants.TOOLBAR_HEIGHT+10,10,10);
        g2.fillRect((Constants.SCREEN_WIDTH/2)+30,Constants.TOOLBAR_HEIGHT+50,10,10);
        g2.fillRect((Constants.SCREEN_WIDTH/2)+40,Constants.TOOLBAR_HEIGHT+10,10,50);

        //links

        g2.setColor(Color.WHITE);
        g2.fillRect((Constants.SCREEN_WIDTH/2)-20-7,Constants.TOOLBAR_HEIGHT+10,10,50);
        g2.fillRect((Constants.SCREEN_WIDTH/2)-30-7,Constants.TOOLBAR_HEIGHT+10,10,10);
        g2.fillRect((Constants.SCREEN_WIDTH/2)-30-7,Constants.TOOLBAR_HEIGHT+50,10,10);
        g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+10,10,50);

        //System.out.println(ball.getCounterL());
        //System.out.println(ball.getCounterR());

        //rechts

        if(ball.getCounterR()==1){

            g2.setColor(Color.BLACK);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,30,50);

            g2.setColor(Color.WHITE);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,10,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+30,Constants.TOOLBAR_HEIGHT+10,10,40);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+50,30,10);

        }
        if(ball.getCounterR()==2){
            g2.setColor(Color.BLACK);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,30,50);

            g2.setColor(Color.WHITE);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+50,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+30,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+40,Constants.TOOLBAR_HEIGHT+20,10,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+40,10,10);

        }
        if(ball.getCounterR()==3){
            g2.setColor(Color.BLACK);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,30,50);

            g2.setColor(Color.WHITE);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+50,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+30,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+40,Constants.TOOLBAR_HEIGHT+20,10,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+40,Constants.TOOLBAR_HEIGHT+40,10,10);

        }
        if(ball.getCounterR()==4){
            g2.setColor(Color.BLACK);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,30,50);

            g2.setColor(Color.WHITE);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,10,20);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+40,Constants.TOOLBAR_HEIGHT+10,10,50);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+30,30,10);


        }
        if(ball.getCounterR()==5){
            g2.setColor(Color.BLACK);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,30,50);
            g2.setColor(Color.WHITE);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+50,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+30,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+40,Constants.TOOLBAR_HEIGHT+40,10,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+20,10,10);


        }
        if(ball.getCounterR()==6){
            g2.setColor(Color.BLACK);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,30,50);
            g2.setColor(Color.WHITE);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,10,50);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+30,Constants.TOOLBAR_HEIGHT+10,20,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+30,Constants.TOOLBAR_HEIGHT+30,20,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+30,Constants.TOOLBAR_HEIGHT+50,20,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+40,Constants.TOOLBAR_HEIGHT+40,10,10);



        }
        if(ball.getCounterR()==7){
            g2.setColor(Color.BLACK);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,30,50);
            g2.setColor(Color.WHITE);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+40,Constants.TOOLBAR_HEIGHT+10,10,50);
            g2.fillRect((Constants.SCREEN_WIDTH/2)+20,Constants.TOOLBAR_HEIGHT+10,20,10);


            Font font = new Font("Dialog", Font.PLAIN, 40);
            Text text = new Text("PLAYER 2 WINS!", font, Constants.SCREEN_WIDTH/2-Constants.SCREEN_WIDTH/4.5, Constants.SCREEN_HEIGHT/2-Constants.SCREEN_HEIGHT/4);
            text.draw(g2);




        }


        //left

        if(ball.getCounterL()==1){

            g2.setColor(Color.BLACK);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-47,Constants.TOOLBAR_HEIGHT+10,30,50);

            g2.setColor(Color.WHITE);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+10,10,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-30-7,Constants.TOOLBAR_HEIGHT+10,10,40);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+50,30,10);

        }
        if(ball.getCounterL()==2){
            g2.setColor(Color.BLACK);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-47,Constants.TOOLBAR_HEIGHT+10,30,50);

            g2.setColor(Color.WHITE);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+10,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+50,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+30,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+40,10,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-20-7,Constants.TOOLBAR_HEIGHT+20,10,10);

        }
        if(ball.getCounterL()==3){
            g2.setColor(Color.BLACK);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-47,Constants.TOOLBAR_HEIGHT+10,30,50);

            g2.setColor(Color.WHITE);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+10,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+50,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+30,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-20-7,Constants.TOOLBAR_HEIGHT+20,10,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-20-7,Constants.TOOLBAR_HEIGHT+40,10,10);

        }
        if(ball.getCounterL()==4){
            g2.setColor(Color.BLACK);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-47,Constants.TOOLBAR_HEIGHT+10,30,50);

            g2.setColor(Color.WHITE);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+10,10,20);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-20-7,Constants.TOOLBAR_HEIGHT+10,10,50);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+30,30,10);


        }
        if(ball.getCounterL()==5){
            g2.setColor(Color.BLACK);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-47,Constants.TOOLBAR_HEIGHT+10,30,50);
            g2.setColor(Color.WHITE);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+10,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+50,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+30,30,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-20-7,Constants.TOOLBAR_HEIGHT+40,10,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+20,10,10);


        }
        if(ball.getCounterL()==6){
            g2.setColor(Color.BLACK);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-47,Constants.TOOLBAR_HEIGHT+10,30,50);
            g2.setColor(Color.WHITE);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-40-7,Constants.TOOLBAR_HEIGHT+10,10,50);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-30-7,Constants.TOOLBAR_HEIGHT+10,20,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-30-7,Constants.TOOLBAR_HEIGHT+30,20,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-30-7,Constants.TOOLBAR_HEIGHT+50,20,10);
            g2.fillRect((Constants.SCREEN_WIDTH/2)-20-7,Constants.TOOLBAR_HEIGHT+40,10,10);



        }
        if(ball.getCounterL()==7) {
            g2.setColor(Color.BLACK);
            g2.fillRect((Constants.SCREEN_WIDTH / 2) - 47, Constants.TOOLBAR_HEIGHT + 10, 30, 50);
            g2.setColor(Color.WHITE);
            g2.fillRect((Constants.SCREEN_WIDTH / 2) - 20 - 7, Constants.TOOLBAR_HEIGHT + 10, 10, 50);
            g2.fillRect((Constants.SCREEN_WIDTH / 2) - 40 - 7, Constants.TOOLBAR_HEIGHT + 10, 20, 10);


            Font font = new Font("Dialog", Font.PLAIN, 40);
            Text text = new Text("PLAYER 1 WINS!", font, Constants.SCREEN_WIDTH/2-Constants.SCREEN_WIDTH/4.5, Constants.SCREEN_HEIGHT/2-Constants.SCREEN_HEIGHT/4);
            text.draw(g2);


        }



        playerOne.draw(g2);
        playerTwo.draw(g2);
        ballRect.draw(g2);



    }


    public void run() {
        double lastFrameTime = 0.0;

        while (true) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;

            update(deltaTime);

            //try {
                //Thread.sleep(15);  // maybe change to 30 milliseconds later == 30 fps

            //} catch (Exception e) {

            //}
        }

    }


}

