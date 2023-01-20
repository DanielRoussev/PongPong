import java.awt.event.KeyEvent ;

public class PlayerControllerTwo {
    public Rect rect;
    public KL keyListener;

    public PlayerControllerTwo(Rect rect, KL keyListener){

        this.rect = rect;
        this.keyListener = keyListener;

    }

    public void update(double dt){
        if (keyListener.isKeyPressed(KeyEvent.VK_UP)){
            if (rect.y >Constants.TOOLBAR_HEIGHT) {
                this.rect.y -= Constants.BALL_SPEED * dt;
            }
        }
        if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)){
            if ((rect.y + 100*dt) + Constants.PADDLE_HEIGHT + rect.width/2< Constants.SCREEN_HEIGHT) {
                this.rect.y += Constants.BALL_SPEED * dt;
            }
        }
    }
}
