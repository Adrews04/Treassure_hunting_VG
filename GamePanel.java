import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable{

    final int original_size = 6;
    final int scale = 7;

    final int title_size = original_size * scale;
    final int max_screen_col = 20;
    final int max_screen_row = 28;
    final int screen_width = title_size * max_screen_col;
    final int screen_height = title_size * max_screen_row;

    //FPS
    int FPS = 60;

    KeyHandler KeyH = new KeyHandler();

    Thread game_thread;

    //PLAYER DEFAULT CONFIGURATION
    int player_Xposition = 100;
    int player_Yposition = 100;
    int player_speed = 4;


    public GamePanel(){

        this.setPreferredSize(new Dimension(screen_width, screen_height));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(KeyH);
        this.setFocusable(true);

    }

    public void  startGameThread(){
        game_thread = new Thread(this);
        game_thread.start();
    }

    @Override
    public void run(){

        double draw_interval = 10E8/FPS;
        double next_draw_interval = System.nanoTime()+draw_interval;

        while(game_thread != null){

            //UPDATE: Character position for example
            update();

            //DRAW THE SCREEN
            repaint();

            try{
                double remaining_time = next_draw_interval- System.nanoTime();
                remaining_time /= 10E5;

                if(remaining_time < 0){
                    remaining_time = 0;
                }

                Thread.sleep((long) remaining_time);

                next_draw_interval += draw_interval;

            }catch(InterruptedException e){
                e.printStackTrace();
            }

        }
    }

        public void update(){
            if(KeyH.up_pressed == true){
                player_Yposition -= player_speed;
            }

            else if(KeyH.down_pressed == true ){
                player_Yposition += player_speed;
            }

            else if(KeyH.left_pressed == true ){
                player_Xposition -= player_speed;
            }

            else if(KeyH.right_pressed == true ){
                player_Xposition += player_speed;
            }
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D)g;

            g2.setColor(Color.white);

            g2.fillRect(player_Xposition, player_Yposition, title_size, title_size);

            g2.dispose();
        }
}