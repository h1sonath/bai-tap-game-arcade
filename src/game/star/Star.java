package game.star;

import base.GameObject;
import base.Vector2D;
import renderer.ImageRenderer;

public class Star extends GameObject {

    public Vector2D velocity;

    public Star() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/star.png", 5, 5);
    }

    @Override
    public void run() {
        super.run();
        this.position.subtractBy(this.velocity);
    }
}
