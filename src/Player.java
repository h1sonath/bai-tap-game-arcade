import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player {

    public Random random = new Random();
    public int x[] = {80, 50, 80};
    public int y[] = {160, 80, 160};

    public int velocity;

    public void render(Graphics graphics) {
        graphics.setColor(Color.WHITE);
        graphics.drawPolygon(this.x, this.y, 3);
    }
    }

