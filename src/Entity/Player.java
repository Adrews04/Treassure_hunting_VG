package src.Entity;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import src.main.GamePanel;
import src.main.KeyHandler;

public class Player extends Entity {

    GamePanel game_p;
    KeyHandler key_h;

    public Player(GamePanel game_p, KeyHandler key_h) {
        this.game_p = game_p;
        this.key_h = key_h;
        setDefaultValues();
        getPlayerImage();
    }

    public void getPlayerImage() {

        try {

            up_img_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_1.png"));
            up_img_2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_up_2.png"));
            down_img_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_1.png"));
            down_img_2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_down_2.png"));
            right_img_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_1.png"));
            right_img_2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_right_2.png"));
            left_img_1 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_1.png"));
            left_img_2 = ImageIO.read(getClass().getResourceAsStream("/res/player/boy_left_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setDefaultValues() {
        x_position = 100;
        y_position = 100;
        speed = 4;
        direction = "down";
    }

    public void update() {

        if (key_h.down_pressed || key_h.left_pressed || key_h.right_pressed || key_h.up_pressed) {
            if (key_h.up_pressed == true) {
                direction = "up";
                y_position -= speed;
            }

            else if (key_h.down_pressed == true) {
                direction = "down";
                y_position += speed;
            }

            else if (key_h.left_pressed == true) {
                direction = "left";
                x_position -= speed;
            }

            else if (key_h.right_pressed == true) {
                direction = "right";
                x_position += speed;
            }

            sprite_counter++;
            if (sprite_counter > 10) {
                switch (sprite_number) {
                    case 1:
                        sprite_number = 2;
                        break;
                    case 2:
                        sprite_number = 1;
                        break;
                    default:
                        break;
                }
                sprite_counter = 0;
            }
        }
    }

    public void draw(Graphics2D g2) {
        /*
         * g2.setColor(Color.white);
         * 
         * g2.fillRect(x_positon, y_position, game_p.title_size, game_p.title_size);
         */

        BufferedImage image = null;

        switch (direction) {
            case "up":
                if (sprite_number == 1) {
                    image = up_img_1;
                }
                if (sprite_number == 2) {
                    image = up_img_2;
                }
                break;

            case "down":
                if (sprite_number == 1) {
                    image = down_img_1;
                }
                if (sprite_number == 2) {
                    image = down_img_2;
                }
                break;

            case "right":
                if (sprite_number == 1) {
                    image = right_img_1;
                }
                if (sprite_number == 2) {
                    image = right_img_2;
                }
                break;

            case "left":
                if (sprite_number == 1) {
                    image = left_img_1;
                }
                if (sprite_number == 2) {
                    image = left_img_2;
                }
                break;

            default:
                break;
        }
        g2.drawImage(image, x_position, y_position, game_p.title_size, game_p.title_size, null);
    }
}
