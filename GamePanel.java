import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

    final int original_size = 6;
    final int scale = 7;

    final int title_size = original_size * scale;
    final int max_screen_col = 16;
    final int max_screen_row = 12;
    final int screen_width = title_size * max_screen_col;
    final int screen_height = title_size * max_screen_row;

    KeyHandler KeyH = new KeyHandler()

    Thread game_thread;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screen_width, screen_height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

    }

    public void  startGameThread(){
        game_thread = new Thread(this);
        game_thread.start();
    }

    @Override
    public void run(){
        while(game_thread != null){
            
            //UPDATE: Character position for example
            update();

            //DRAW THE SCREEN
            repaint();

        }
    }

        public void update(){

        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;

            g2.setColor(Color.white);

            g2.fillRect(100, 100, title_size, title_size);

            g2.dispose();
        }
}