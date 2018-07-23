import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameWindow extends JFrame {

    private GameCanvas gameCanvas;
    private long lastTime = 0;
    private Random random = new Random();
    public GameWindow() {
        this.setSize(1024, 600);

        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.positionXPlayer -= 5;
                    if(gameCanvas.positionXPlayer<0)
                    {
                        gameCanvas.positionXPlayer=1024;
                        gameCanvas.positionYPlayer= random.nextInt(600);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.positionXPlayer += 5;
                    if(gameCanvas.positionXPlayer>1024)
                    {
                        gameCanvas.positionXPlayer=0;
                        gameCanvas.positionYPlayer= random.nextInt(600);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    gameCanvas.positionYPlayer -= 5;
                    if(gameCanvas.positionYPlayer<0)
                    {
                        gameCanvas.positionYPlayer=600;
                        gameCanvas.positionXPlayer = random.nextInt(600);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    gameCanvas.positionYPlayer += 5;
                    if(gameCanvas.positionYPlayer>600)
                    {
                        gameCanvas.positionYPlayer=0;
                        gameCanvas.positionXPlayer = random.nextInt(600);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });

        this.setVisible(true);
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.positionXStar += 5;
                this.gameCanvas.enemyMovement();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}


