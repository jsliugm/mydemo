package com.gui;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends Frame {
    private List<Point> pointList ;

    void init(){
        pointList = new ArrayList<>();
        setBounds(100,100,800,400);
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                pointList.add(new Point(e.getX(),e.getY()));
                repaint();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(-1);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.green);
        for (Point point : pointList) {
            g.fillOval(point.getX(),point.getY(),5,5);
        }
        g.setColor(color);
    }


    public static void main(String[] args) {
        MyFrame myFrame = new MyFrame();
        myFrame.init();
    }
}
class Point{
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
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
}