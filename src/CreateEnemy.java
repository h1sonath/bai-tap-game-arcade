import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CreateEnemy {
    public List<Enemy> enemies = new ArrayList<>();
    private int timeIntervalEnemy =0;
    private Random random = new Random();
    public void run() {
            if (this.timeIntervalEnemy == 50) {
                Enemy enemy = new Enemy();
                enemy.position.set(this.random.nextInt(1024)+1, this.random.nextInt(600)+1);
                enemy.velocity.set(this.random.nextInt(3) + 1, this.random.nextInt(3) + 1);
                this.enemies.add(enemy);
                this.timeIntervalEnemy = 0;
            } else {
                this.timeIntervalEnemy += 1;
            }
        this.enemies.forEach(enemy -> enemy.run());
        }

    public void render(Graphics graphics) {
        this.enemies.forEach(enemy -> enemy.render(graphics));
    }
}
