
import java.awt.event.KeyEvent ;

public class PlayerController {
    public Rect rect;
    public KL keyListener;

    public PlayerController(Rect rect, KL keyListener) {

        this.rect = rect;
        this.keyListener = keyListener;

    }

    public void update(double dt) {
        if (keyListener.isKeyPressed(KeyEvent.VK_W)) {
            if (rect.y > Constants.TOOLBAR_HEIGHT) {
                this.rect.y -= Constants.BALL_SPEED * dt;
            }
        }
        if (keyListener.isKeyPressed(KeyEvent.VK_S)) {
            if ((rect.y + 100*dt) + Constants.PADDLE_HEIGHT < Constants.SCREEN_HEIGHT - Constants.INSETS_BOTTOM) {
                this.rect.y += Constants.BALL_SPEED* dt;
            }
        }
    }
}
