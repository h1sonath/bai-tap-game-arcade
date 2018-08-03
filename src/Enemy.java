import java.awt.*;
public class Enemy {

    public Vector2D position;
    public EnemyShoot enemyShoot;
    public Vector2D velocity;
    public Renderer renderer;

    public Enemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.enemyShoot = new EnemyAttack();
        this.renderer = new ImageRenderer("resources/images/circle.png", 20, 20);
    }

    public void run() {
        this.position.addUp(this.velocity);
        this.enemyShoot.run(this);
    }

    public void render(Graphics graphics) {
        this.renderer.render(graphics, this.position);
        ((EnemyAttack) this.enemyShoot).bulletEnemies.forEach(bulletEnemy ->  bulletEnemy.render(graphics));
    }
}