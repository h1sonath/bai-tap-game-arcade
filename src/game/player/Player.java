package game.player;

import base.GameObject;
import base.Vector2D;
import physic.BoxCollider;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject {

    public Vector2D velocity;
    public BoxCollider boxCollider;

    public double angle = 0.0;

    public Player() {
        this.velocity = new Vector2D();

        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.attributes.add(new PlayerShoot());
        this.attributes.add(new PlayerMove());
        this.boxCollider = new BoxCollider(16, 20);

    }

    @Override
    public void run() {
        super.run();
        ((PolygonRenderer) this.renderer).angle = this.angle;
        this.boxCollider.position.set(this.position.x - 10, this.position.y -8);
    }
}
