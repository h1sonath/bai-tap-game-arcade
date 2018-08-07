package game.enemyfollow;
import base.FrameCounter;
import base.GameObject;
import base.GameObjectManager;
import java.util.Random;


public class CreateEnemyFollow extends GameObject {

    private Random random;
    private FrameCounter frameCounter;

    public CreateEnemyFollow() {
        this.random = new Random();
        this.frameCounter = new FrameCounter(50);
    }

    public void run() {
        super.run();
        if (this.frameCounter.run()) {
            EnemyFollow enemy = new EnemyFollow();
            enemy.position.set(this.random.nextInt(1024), this.random.nextInt(600));

            GameObjectManager.instance.add(enemy);
            this.frameCounter.reset();
        }
    }
}