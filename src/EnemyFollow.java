import java.awt.*;

public class EnemyFollow {

    public Vector2D position;
    public Renderer renderer;

    public Vector2D velocity;

    public EnemyFollow() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
    }
    public void run() {
        this.position.addUp(this.velocity);
    }
    public void update(Vector2D position) {
        this.velocity.set(
                position.subtract(this.position).normalized()
        ).multiply(1.5f);

    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);

    }
}