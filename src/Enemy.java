import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Enemy {
    public BufferedImage image;

    public Vector2D position;
    public Vector2D velocity;

    public int width;
    public int height;

    private Vector2D bulletVelocity = new Vector2D(5,0);
    private List<BulletEnemy> bulletEnemies;
    private int timeIntervalBullet = 0;

    Random random = new Random();
    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.bulletEnemies = new ArrayList<>();
    }

    public void run() {
        this.position = position.add(velocity);

        this.shoot();
    }

    private void shoot() {
        if (this.timeIntervalBullet == 35) {
            BulletEnemy bulletEnemy = new BulletEnemy();
            try {
                bulletEnemy.image = ImageIO.read(new File("resources/images/star.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            bulletEnemy.position.set((int) this.position.x, (int) this.position.y);
            bulletEnemy.velocity.set(this.bulletVelocity.x, this.bulletVelocity.y);
           bulletVelocity= bulletVelocity.rotate(10);
            this.bulletEnemies.add(bulletEnemy);
            this.timeIntervalBullet = 0;
        } else {
            this.timeIntervalBullet += 1;
        }

        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, this.width, this.height, null);
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }
}