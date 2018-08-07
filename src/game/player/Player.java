package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import renderer.PolygonRenderer;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    public double angle =0.0;
    public Vector2D velocity;
    private Random random = new Random();
    public PlayerShoot playerShoot;

    public Player() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();

        this.renderer = new PolygonRenderer(Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerShoot = new PlayerAttack();
    }


    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        ((PolygonRenderer) this.renderer).angle = angle;
        this.backToScreen();
        this.playerShoot.run(this);
    }

    private void backToScreen() {
        if (this.position.x > 1024) this.position.set(0, this.random.nextInt(600));
        if (this.position.x < 0) this.position.set(1024, this.random.nextInt(600));
        if (this.position.y > 600) this.position.set(this.random.nextInt(1024), 0);
        if (this.position.y < 0) this.position.set(this.random.nextInt(1024), 600);
    }
}
