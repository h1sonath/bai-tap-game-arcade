import java.awt.*;

public class BackgroundRenderer implements Renderer {
    private Color color;
    public BackgroundRenderer(Color color  ) {
        this.color = color;
    }


    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.setColor(color);
        graphics.fillRect((int) position.x, (int) position.y, 1024, 600);
    }
}
