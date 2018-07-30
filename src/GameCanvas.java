import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {
    private Background background = new Background();
    private List<Star> stars;
    private List<Enemy> enemies;
    private BufferedImage backBuffered;

    public Player player;
    public Enemy enemy;
    private Graphics graphics;

    private Random random = new Random();

    private int timeIntervalStar = 0;
    private int timeIntervalEnemy = 0;


    public GameCanvas() {

        this.setSize(1024, 600);

        this.setupBackBuffered();

        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.setupStar();
        this.enemies = new ArrayList<>();
        this.setupPlayer();
    }

    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(200, 300);
        this.player.velocity.set(2, 0);
    }

    private void setupStar() {
        this.stars = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(graphics);

        this.stars.forEach(star -> star.render(graphics));

        this.player.render(this.graphics);

        this.enemies.forEach(enemy -> enemy.render(graphics));

        this.repaint();
    }

    public void runAll() {
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.createEnemy();
        this.enemies.forEach(enemy -> enemy.run());
        this.player.run();
    }

    private void createStar() {
        if (this.timeIntervalStar == 30) {
            Star star = new Star();
            star.position.set(1024, this.random.nextInt(600));
            star.image = this.loadImage("resources/images/star.png");
            star.width = 15;
            star.height = 15;
            star.velocity.set(this.random.nextInt(3) + 1, 0);
            this.stars.add(star);
            this.timeIntervalStar = 0;
        } else {
            this.timeIntervalStar += 1;
        }

    }

    private void createEnemy() {
        if (this.timeIntervalEnemy == 50) {
            this.enemy = new Enemy();
            this.enemy.position.set(this.random.nextInt(1024),this.random.nextInt(600));
            this.enemy.image = this.loadImage("resources/images/circle.png");
            this.enemy.width = 20;
            this.enemy.height = 20;
            this.enemy.velocity.set(3,0);
            this.enemy.velocity = enemy.velocity.normalized();
            this.enemies.add(enemy);
            this.timeIntervalEnemy = 0;
        } else timeIntervalEnemy++;
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}