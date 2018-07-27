import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {

    public int x[] = {80, 40, 80};
    public int y[] = {160, 80, 160};

    public int velocity;

    public void render(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawPolygon(this.x, this.y, 3);
    }
    }

