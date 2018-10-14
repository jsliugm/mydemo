package com.graphics;

import java.awt.*;

/**
 * Created by c_liuguangming on 2017/1/19.
 */
public class Cell {
    private String content;
    private Color fontColor = Color.BLACK;
    private Arrow arrow ;
    private int x;//x偏移量
    private int y;//y偏移量

    public Cell(String content, int x, int y) {
        this.content = content;
        this.x = x;
        this.y = y;
    }

    public Cell(String content, Arrow arrow) {
        this.content = content;

        this.arrow = arrow;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public void setArrowColor(Color color) {
        arrow.setColor(color);
    }

    public Arrow getArrow() {
        return arrow;
    }

    public void setArrow(Arrow arrow) {
        this.arrow = arrow;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
