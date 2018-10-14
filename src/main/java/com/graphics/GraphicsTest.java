package com.graphics;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by c_liuguangming on 2017/1/17.
 */
public class GraphicsTest {
    public static void saveImage(BufferedImage image,String path) throws IOException {
        ImageIO.write(image,"png",new File(path));
        image.flush();
    }
    public static void drawContent(Graphics graphics){
        Graphics2D g = (Graphics2D)graphics;
        Font font = new Font("微软雅黑", Font.PLAIN, 17);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("哈哈哈",10,10);
        g.setColor(Color.green);
       // g.fillArc(10, 10, 60, 40, 30, 60);
       /* g.fillOval(10, 60, 60, 40);
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
            g.draw3DRect(150 - i, 60 + i, 60, 40, true);*/
    }
    public static void main(String[] args) throws IOException {
        BufferedImage bi = new BufferedImage(380, 200, BufferedImage.TYPE_INT_RGB);
        //ImageIO.read(new File("e:/image/bg.jpg"));
        Graphics graphics = bi.getGraphics();
        graphics.setColor(new Color(255,255,203));
        graphics.fillRect(0,0,360,200);
        drawContent(graphics);
        saveImage(bi,"e:/image/test.png");
    }
}
