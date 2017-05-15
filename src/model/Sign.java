package model;

import javafx.scene.shape.Rectangle;

import java.awt.image.BufferedImage;

/**
 * Created by staho on 13.05.2017.
 */
public class Sign extends Rectangle{
    private BufferedImage part;
    private boolean cirle;

    public boolean isCirle() {
        return cirle;
    }

    public void setCirle(boolean cirle) {
        this.cirle = cirle;
    }

    public Sign(double width, double height, BufferedImage part, boolean cirle) {
        super(width, height);
        this.part = part;
        this.cirle = cirle;
    }

    public Sign(BufferedImage part, boolean cirle) {
        this.part = part;
        this.cirle = cirle;
    }
}
