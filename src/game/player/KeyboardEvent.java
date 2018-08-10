package game.player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class KeyboardEvent implements KeyListener {


        public static KeyboardEvent instance = new KeyboardEvent();

        public int angle;
        public float multiply;

        private KeyboardEvent() {
            this.angle = 0;
            this.multiply = 1;
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                this.multiply = 2;
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                angle -= 5.0;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                angle += 5.0;
            }

        }
        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                this.multiply = 1;
            }
        }
    }

