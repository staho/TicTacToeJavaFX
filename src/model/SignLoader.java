package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by staho on 13.05.2017.
 */
public class SignLoader {
    //sign
    //true stands for circle
    //false for cross
    static public Sign generateSignRectangle(boolean sign, File file){
        return new Sign(150, 150, getImageFromFile(file), sign);
    }

    static public BufferedImage getImageFromFile(File file){
        try {
            BufferedImage image = ImageIO.read(file);

            if(image.getHeight() != 150 && image.getWidth() != 150){
                Image tmp = image.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                BufferedImage img = new BufferedImage(150, 150, BufferedImage.TYPE_INT_ARGB);

                Graphics2D g2d = img.createGraphics();
                g2d.drawImage(tmp, 0, 0, null);
                g2d.dispose();
                return img;
            }
            return image;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
