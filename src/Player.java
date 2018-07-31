import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Player {

    public Vector2D position;
    public Vector2D velocity;
    private int timeIntervalFollow=0;
    private List<Vector2D> vertices;
    public Vector2D bulletRotate = new Vector2D(3,0 );
    private Polygon polygon;

    public double angle = 0.0;


    public List<BulletPlayer> bulletPlayers;
    private List<EnemyFollow> enemyFollows;
    private int timeIntervalShoot = 0;
    private Random random = new Random();
    public Player() {

        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.bulletPlayers = new ArrayList<>();
        this.enemyFollows = new ArrayList<>();


        this.vertices = Arrays.asList(
                new Vector2D(),
                new Vector2D(0, 18),
                new Vector2D((float) (Math.sqrt(3)/2)*18, 9)
        );
        this.polygon = new Polygon();
    }

    public void run() {

        this.position.addUp(this.velocity);
        this.shoot();
        this.follow();
    }
    private void shoot() {
        if (this.timeIntervalShoot == 30) {
            BulletPlayer bulletPlayer = new BulletPlayer();
            try {
                bulletPlayer.image = ImageIO.read(new File("resources/images/circle.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            bulletPlayer.position.set(this.position.x, this.position.y);
            bulletPlayer.velocity.set(this.bulletRotate.x, this.bulletRotate.y);

            this.bulletPlayers.add((bulletPlayer));
            this.timeIntervalShoot = 0;
        } else {
            this.timeIntervalShoot += 1;
        }

        this.bulletPlayers.forEach(bulletPlayer-> bulletPlayer.run());
    }
    public void follow() {
        if (this.timeIntervalFollow == 150) {
            EnemyFollow enemyFollow = new EnemyFollow();
            try {
                enemyFollow.image = ImageIO.read(new File("resources/images/circle.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            enemyFollow.position.set(random.nextInt(1024), random.nextInt(600));
            this.enemyFollows.add(enemyFollow);
            this.timeIntervalFollow = 0;
        } else {
            this.timeIntervalFollow += 1;
        }

        this.enemyFollows.forEach(enemyFollow -> enemyFollow.run());
        this.enemyFollows.forEach(enemyFollow -> enemyFollow.updateVelocity(this.position));
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);

        this.updateTriangle();

        graphics.fillPolygon(this.polygon);
        this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
        this.enemyFollows.forEach(enemyFollow -> enemyFollow.render(graphics));

    }

    private void updateTriangle() {
        this.polygon.reset();
        Vector2D center = this.vertices
                .stream()
                .reduce(new Vector2D(), (v1, v2) -> v1.add(v2))
                .multiply(1.0f / (float) this.vertices.size())
                .rotate(this.angle);

        Vector2D translate = this.position.subtract(center);

        this.vertices
                .stream()
                .map(vector2D -> vector2D.rotate(angle))
                .map(vector2D -> vector2D.add(translate))
                .forEach(vector2D -> polygon.addPoint((int) vector2D.x, (int) vector2D.y));
    }
}

