package com.graphics;

import java.awt.*;

/**
 * Created by c_liuguangming on 2017/1/18.
 */
public enum Arrow {
    UP(Color.RED), DOWN(Color.GREEN), LEFT(Color.BLUE), RIGHT(Color.BLUE);
    private Color color;

    Arrow(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}