import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow extends JFrame {

    private GameCanvas gameCanvas;
    private long lastTime = 0;

    public GameWindow() {
        this.setSize(1024, 600);

        this.setupGameCanvas();

        this.event();

        this.setVisible(true);
    }

    private void setupGameCanvas() {
        this.gameCanvas = new GameCanvas();
        this.add(this.gameCanvas);
    }

    private void event() {
        this.keyboardEvent();
        this.windowEvent();
    }

    private void keyboardEvent() {
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    gameCanvas.player.velocity.multiply(10);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    gameCanvas.player.angle -= 5;
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    gameCanvas.player.angle += 5;
                }

                gameCanvas.player.velocity.set(new Vector2D(2, 0).rotate(gameCanvas.player.angle)
                );
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    gameCanvas.player.velocity.multiply(0.5f);
                }
            }
        });
    }

    private void windowEvent() {
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }

    public void gameLoop() {
        while (true) {
            long currentTime = System.nanoTime();
            if (currentTime - this.lastTime >= 17_000_000) {
                this.gameCanvas.runAll();
                this.gameCanvas.renderAll();
                this.lastTime = currentTime;
            }
        }
    }
}