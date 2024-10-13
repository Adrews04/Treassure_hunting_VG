package src.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import src.Entity.Player;

public class GamePanel extends JPanel implements Runnable{

    final int original_size = 6;
    final int scale = 7;

    public final int title_size = original_size * scale;
    public final int max_screen_col = 20;
    public final int max_screen_row = 28;
    public final int screen_width = title_size * max_screen_col;
    public final int screen_height = title_size * max_screen_row;

    //FPS
    int FPS = 60;

    KeyHandler key_h = new KeyHandler();

    Thread game_thread;

    Player player = new Player(this, key_h);

    //PLAYER DEFAULT CONFIGURATION
    int player_Xposition = 100;
    int player_Yposition = 100;
    int player_speed = 4;


    public GamePanel(){

        this.setPreferredSize(new Dimension(screen_width, screen_height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(key_h);
        this.setFocusable(true);

    }

    public void  startGameThread(){
        game_thread = new Thread(this);
        game_thread.start();
    }

    @Override
    public void run(){

        double draw_interval = 10E8/FPS;
        double delta = 0;
        long last_time = System.nanoTime();
        long current_time;

        while(game_thread != null){

            current_time = System.nanoTime();

            delta += (current_time- last_time) / draw_interval;

            last_time = current_time;

            if(delta >= 1){
                update();
                repaint();
                delta--;
            }
        }
    }

        public void update(){
            player.update();
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;

            player.draw(g2);

            g2.dispose();
        }
}