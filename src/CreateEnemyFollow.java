import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateEnemyFollow {
    public List<EnemyFollow> enemiesFollow = new ArrayList<>();
    private int timeIntervalEnemy =0;
    public EnemyFollow enemyFollow;
    private Random random = new Random();
    public void run() {

        if (this.timeIntervalEnemy == 50) {
            enemyFollow = new EnemyFollow();
            enemyFollow.position.addUp(enemyFollow.velocity);
            enemyFollow.position.set(this.random.nextInt(1024), this.random.nextInt(600));
            enemyFollow.velocity.set(this.random.nextInt(3) + 1, this.random.nextInt(3) + 1);
            this.enemiesFollow.add(enemyFollow);
            this.timeIntervalEnemy = 0;
        } else {
            this.timeIntervalEnemy += 1;
        }
        this.enemiesFollow.forEach(enemy -> enemy.run());
    }
    public void updateVelocity(Vector2D vector2D){
        this.enemiesFollow.forEach(enemyFollow -> enemyFollow.update(vector2D));
    }


    public void render(Graphics graphics) {
        this.enemiesFollow.forEach(enemy -> enemy.render(graphics));
    }
}

