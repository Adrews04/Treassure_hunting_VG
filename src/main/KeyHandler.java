package src.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean down_pressed;
    public boolean up_pressed;
    public boolean right_pressed;
    public boolean left_pressed;

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_W:
                up_pressed = true;
                break;
            case KeyEvent.VK_A:
                left_pressed = true;
                break;
            case KeyEvent.VK_S:
                down_pressed = true;
                break;
            case KeyEvent.VK_D:
                right_pressed = true;
                break;
            default:
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        switch (code) {
            case KeyEvent.VK_W:
                up_pressed = false;
                break;
            case KeyEvent.VK_A:
                left_pressed = false;
                break;
            case KeyEvent.VK_S:
                down_pressed = false;
                break;
            case KeyEvent.VK_D:
                right_pressed = false;
                break;

            default:
                break;
        }
    }

}
