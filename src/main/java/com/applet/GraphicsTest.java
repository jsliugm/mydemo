package com.applet;

import java.applet.Applet;
import java.awt.*;

/**
 * Created by c_liuguangming on 2017/1/17.
 */
public class GraphicsTest extends Applet {
    @Override
    public void paint(Graphics g) {
       //setBackground(Color.black);
        g.setColor(Color.green);
        g.fillArc(10, 10, 60, 40, 30, 60);
        g.fillOval(10, 60, 60, 40);
        g.fillRect(80, 10, 60, 40);
        Polygon p = new Polygon();
        p.addPoint(150, 10);
        p.addPoint(210, 10);
        p.addPoint(210, 50);
        p.addPoint(150, 50);
        g.fillPolygon(p);   //绘制高度为5个像素，视角为45度正方向的3维矩形
        g.fill3DRect(150, 10, 60, 40, true);
        for (int i=1; i<=5; i++)
            g.draw3DRect(150 + i, 10 - i, 60, 40, true);
        //绘制高度为5个像素，视角为135度正方向的3维矩形
        g.fill3DRect(150, 60, 60, 40, true);
        for (int i=1; i<=5; i++)
            g.draw3DRect(150 - i, 60 + i, 60, 40, true);
    }
}
