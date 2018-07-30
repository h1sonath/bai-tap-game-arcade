import java.awt.*;

public class Background {
    public Vector2D position;
    public int width;
    public int height;

    public Background() {
        position = new Vector2D();
        position.x = 0;
        position.y = 0;
        width = 1024;
        height = 600;
    }
    public void render(Graphics graphics) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect((int) position.x, (int) position.y, width, height);
    }
}

