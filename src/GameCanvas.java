import javax.imageio.ImageIO;
        import javax.swing.*;
        import java.awt.*;
        import java.awt.image.BufferedImage;
        import java.io.File;
        import java.io.IOException;


public class GameCanvas extends JPanel {

    private BufferedImage starImage;
    private BufferedImage backBuffered;
    private BufferedImage playerImage;
    private BufferedImage enemyImage;

    public int positionXStar = 0;
    public int positionYStar = 200;

    public int positionXPlayer = 600;
    public int positionYPlayer = 200;

    public int positionXenemy = 300;
    public int positionYenemy = 300;

    public int vx = 5;
    public int vy = 5;

    private Graphics graphics;


    public GameCanvas() {

        this.setSize(1024, 600);

        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_INT_ARGB);
        this.graphics = this.backBuffered.getGraphics();

        // load anh
        try {
            this.starImage = ImageIO.read(new File("resources/images/star.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            this.playerImage = ImageIO.read(new File("resources/images/circle.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.enemyImage = ImageIO.read(new File("resources/images/star.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // draw

        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);

    }

    public void renderAll() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);
        this.graphics.drawImage(this.playerImage, this.positionXPlayer, this.positionYPlayer, 50, 50, null);
        this.graphics.drawImage(this.enemyImage, this.positionXenemy, this.positionYenemy, 50, 50, null);
        this.repaint();
    }
    public void enemyMovement()
    {
        positionXenemy +=vx;
        if(positionXenemy>960 || positionXenemy<15)
        {
            vx=-vx;
        }
        positionYenemy +=vy;

        if(positionYenemy>515 || positionYenemy < 15)
        {
            vy=-vy;
        }
    }
}




