import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GameCanvas extends JPanel {

    private List<Enemy> enemies;
    private BufferedImage backBuffered;
    private Background background = new Background();
    private CreateEnemy createEnemy = new CreateEnemy();
    private CreateEnemyFollow createEnemyFollow = new CreateEnemyFollow();
    private CreateStar createStar = new CreateStar();

    public Player player;

    private Graphics graphics;

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
        this.enemies = new ArrayList<>();
        this.setupPlayer();
    }

    private void setupPlayer() {
        this.player = new Player();
        this.player.position.set(200, 300);
        this.player.velocity.set(3.5f, 0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);
        this.player.render(this.graphics);
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.createEnemy.render(graphics);
        this.createEnemyFollow.render(this.graphics);
        this.createStar.render(graphics);
        this.repaint();
    }

    public void runAll() {
        this.enemies.forEach(enemy -> enemy.run());
        this.player.run();
        this.createEnemy.run();
        this.createEnemyFollow.updateVelocity(this.player.position);
        this.createEnemyFollow.run();
        this.createStar.run();
    }
}




