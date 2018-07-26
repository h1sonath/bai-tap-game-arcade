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

    private List<Star> stars;
    public Player player = new Player();
    private BufferedImage backBuffered;

    private Graphics graphics;

    private Random random = new Random();

    private int timeIntervalStar = 0;


    public GameCanvas() {
        this.player.x[0]=500;
        this.player.y[0]=400;

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
    }

    private void setupStar() {
        this.stars = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.renderBackground();
        this.stars.forEach(star -> star.render(graphics));
        if(1!=2)
            this.player.render(graphics);
        this.repaint();
    }

    public void runAll() {
        this.createStar();
        this.createPlayer();
        this.stars.forEach(star -> star.run());
        this.playerMove();
    }
    private void createPlayer(){
        this.player.velocity = 10;
        this.player.x[0]= this.player.x[1]+30;
        this.player.y[0]= this.player.y[1];
        this.player.x[2] = this.player.x[0]+15;
        this.player.y[2] = this.player.y[0]+20;

    }
    public void playerMove() {
        if (this.player.x[0] < 30 && player.x[1] <0 && player.x[2] <0){
            this.player.x[0] = 994;
            this.player.x[1] = 964;
            this.player.x[2] = 1009;
        }
        if (this.player.x[0] > 994 && player.x[1] > 994 && player.x[2] > 994){
            this.player.x[0] = 0;
            this.player.x[1] = -30;
            this.player.x[2] = 15;
        }
        if (this.player.y[0] < 30 && player.y[1] <0 && player.y[2] <0) {
            this.player.y[0] = 550;
            this.player.y[1]=  550;
            this.player.y[2]=  570;
        }
        if (this.player.y[0] > 550&& player.y[1] >550 && player.y[2] >550) {
            this.player.y[0] = 0;
            this.player.y[1]= 0;
            this.player.y[2]=20;
        }
    }
    private void createStar() {
        if (this.timeIntervalStar == 30) {
            Star star = new Star();
            star.x = 924;
            star.y = this.random.nextInt(600);
            star.image = this.loadImage("resources/images/star.png");
            star.width = 10;
            star.height = 10;
            star.velocityX = this.random.nextInt(3) + 1;
            star.velocityY = this.random.nextInt(3 ) +1;
            this.stars.add(star);
            this.timeIntervalStar = 0;
        } else {
            this.timeIntervalStar += 1;
        }
    }
    private void renderBackground() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            return null;
        }
    }
}
