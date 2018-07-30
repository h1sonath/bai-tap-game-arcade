import java.awt.*;
import java.awt.image.BufferedImage;

public class EnemyFollow {
    public BufferedImage image;
    public Vector2D position;
    public Vector2D velocity;
    public EnemyFollow(){
        this.position = new Vector2D();
        this.velocity = new Vector2D();
    }
    public void run(){
        this.position.addUp(velocity);
    }
    public void updateVelocity (Vector2D vector2D){
        velocity.set(vector2D.x - this.position.x, vector2D.y - this.position.y);
        velocity = velocity.normalized();
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image,(int)this.position.x,(int)this.position.y,16,16,null);
    }
}