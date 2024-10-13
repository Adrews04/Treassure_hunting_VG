package src.Entity;

import java.awt.image.BufferedImage;

public class Entity {
    
    public int x_position, y_position;
    public int speed;

    public BufferedImage up_img_1, up_img_2, down_img_1, down_img_2, right_img_1, right_img_2, left_img_1, left_img_2;
    public String direction;

    public int sprite_counter = 0;
    public int sprite_number = 1;

}
