package game.enemyfollow;

import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;

import java.util.Random;

public class CreateEnemyFollow extends GameObject {

    private FrameCounter frameCounter = new FrameCounter(400);
    private Random random = new Random();

    @Override
    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            EnemyFollow enemyFollow = new EnemyFollow();
            enemyFollow.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            GameObjectManager.instance.add(enemyFollow);
            this.frameCounter.reset();
        }
    }
}
