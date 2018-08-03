import java.awt.*;

public class BulletEnemy {

    public Vector2D position;
    public Vector2D velocity;
    public Renderer renderer;

    public BulletEnemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer( "resources/images/circle.png", 5, 5);
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
    }

}