import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {

        boolean down_pressed, up_pressed, right_pressed, left_pressed;

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
        boolean down_pressed, up_pressed, right_pressed, left_pressed, enter_pressed;

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
            case KeyEvent.VK_ENTER:

                break;

            default:
                break;
        }
    }

}
