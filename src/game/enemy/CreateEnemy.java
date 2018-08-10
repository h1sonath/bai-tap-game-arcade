package game.enemy;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class CreateEnemy extends GameObject {

    private Random random;
    private FrameCounter frameCounter;

    public CreateEnemy() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(200);
    }

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            Enemy enemy = new Enemy();
            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            enemy.velocity.set(this.random.nextInt(3) + 1, this.random.nextInt(3) + 1);

            GameObjectManager.instance.add(enemy);
            this.frameCounter.reset();
        }
    }
}
