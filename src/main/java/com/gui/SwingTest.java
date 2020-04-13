package com.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class SwingTest {
    public static void main(String[] args) {
        new MyJFrame().init();
    }
}
class MyJFrame extends JFrame {
    List<Point> points ;
    public void init(){
        points = new ArrayList<>();
        setBounds(100,100,300,400);
        JButton btn1 = new JButton("btn1");
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                points.add(new Point(e.getX(),e.getY()));
                repaint();
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                System.exit(0);
            }
        });
        setLayout(new FlowLayout());
        add(btn1);
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        //super.paint(g);
        g.setColor(Color.black);
        for (Point point : points) {
            g.fillOval(point.getX(),point.getY(),5,5);
        }
        g.setColor(c);
       // repaint();
    }
}