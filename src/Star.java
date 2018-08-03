import java.awt.*;

public class Star {

    public Vector2D position;
    public Renderer renderer;

    public Vector2D velocity;

    public Star() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/star.png", 5, 5);
    }

    public void run() {
        this.position.subtractBy(this.velocity);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);

    }
}