package com.graphics;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageEngine {
    private BufferedImage image;

    void createImage(String fileLocation) {
        try {
            FileOutputStream fos = new FileOutputStream(fileLocation);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
            encoder.encode(image);
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 画绿色向下箭头
    public void getGreenArrow(Graphics graphics, int x, int y) {
        graphics.setColor(new Color(2, 148, 115));
        drawDownArrow(graphics, x, y);
    }

    // 画红色向上箭头
    public void getRedArrow(Graphics graphics, int x, int y) {
        graphics.setColor(new Color(238, 74, 87));
        drawUpArrow(graphics, x, y);
    }

    // 画蓝色向右箭头
    public void getYellowArrow(Graphics graphics, int x, int y) {
        graphics.setColor(new Color(19, 111, 193));
        drawRightArrow(graphics, x, y);
    }

    /**
     * 绘制向右箭头
     *
     * @param graphics
     * @param x
     * @param y
     */
    public void drawRightArrow(Graphics graphics, int x, int y) {
        // 绘制由 x 和 y 坐标数组定义的一系列连接线。
        graphics.drawPolyline(new int[]{x, x - 2, x - 2, x - 10, x - 10,
                x - 2, x - 2, x}, new int[]{y, y - 4, y - 2, y - 2, y + 2,
                y + 2, y + 4, y}, 8);
        // 填充由 x 和 y 坐标数组定义的闭合多边形。
        graphics.fillPolygon(new int[]{x, x - 2, x - 2, x - 10, x - 10,
                x - 2, x - 2, x}, new int[]{y, y - 4, y - 2, y - 2, y + 2,
                y + 2, y + 4, y}, 8);
    }

    /**
     * 绘制向下箭头
     *
     * @param graphics
     * @param x
     * @param y
     */
    public void drawDownArrow(Graphics graphics, int x, int y) {
        // 绘制由 x 和 y 坐标数组定义的一系列连接线。
        graphics.drawPolyline(new int[]{x, x + 4, x + 2, x + 2, x - 2, x - 2,
                x - 4, x}, new int[]{y, y - 4, y - 4, y - 10, y - 10, y - 4,
                y - 4, y}, 8);
        // 填充由 x 和 y 坐标数组定义的闭合多边形。
        graphics.fillPolygon(new int[]{x, x + 4, x + 2, x + 2, x - 2, x - 2,
                x - 4, x}, new int[]{y, y - 4, y - 4, y - 10, y - 10, y - 4,
                y - 4, y}, 8);
    }

    /**
     * 绘制向上箭头
     *
     * @param graphics
     * @param x
     * @param y
     */
    public void drawUpArrow(Graphics graphics, int x, int y) {
        // 绘制由 x 和 y 坐标数组定义的一系列连接线。
        graphics.drawPolyline(new int[]{x, x - 4, x - 2, x - 2, x + 2, x + 2,
                x + 4, x}, new int[]{y, y + 4, y + 4, y + 10, y + 10, y + 4,
                y + 4, y}, 8);
        // 填充由 x 和 y 坐标数组定义的闭合多边形。
        graphics.fillPolygon(new int[]{x, x - 4, x - 2, x - 2, x + 2, x + 2,
                x + 4, x}, new int[]{y, y + 4, y + 4, y + 10, y + 10, y + 4,
                y + 4, y}, 8);
    }

    /**
     * 绘制表格横线
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param rowHeightArray
     * @param graphics
     */
    public void drawX(int x1, int y1, int x2, int y2, int[] rowHeightArray, Graphics graphics) {
        graphics.drawLine(x1, y1, x2, y2);
        for (int i = 0; i < rowHeightArray.length; i++) {
            y1 = y2 = y1 + rowHeightArray[i];
            graphics.drawLine(x1, y1, x2, y2);
        }
    }

    /**
     * 绘制表格竖线
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param columnWidthArray
     * @param graphics
     */
    public void drawY(int x1, int y1, int x2, int y2, int[] columnWidthArray, Graphics graphics) {
        graphics.drawLine(x1, y1, x2, y2);
        for (int i = 0; i < columnWidthArray.length; i++) {
            x1 = x2 = x1 + columnWidthArray[i];
            graphics.drawLine(x1, y1, x2, y2);
        }
    }

    public void drawTable(ImageTable imageTable, Graphics graphics) {
        //划线(起始点(X1,Y1)、结束点(X2,Y2))
        // 画横线
        int x1 = imageTable.getLeft();
        int y1, y2 = y1 = imageTable.getTop();
        int x2 = imageTable.getImageWidth() - imageTable.getRight();
        drawX(x1, y1, x2, y2, imageTable.getRowHeightArray(), graphics);
        //画竖线
        x2 = x1;
        y2 = imageTable.getImageHeight() - imageTable.getBottom();
        drawY(x1, y1, x2, y2, imageTable.getColumnWidthArray(), graphics);
    }

    public void drawContent(Graphics graphics, Color fontColor, ImageTable imageTable) {
        // 写标题
        graphics.setColor(fontColor);
        Font font = new Font("微软雅黑", Font.BOLD, 17);
        graphics.setFont(font);
        int x = imageTable.getImageWidth() / 3 - 20; // 调节标题水平位置
        int y = imageTable.getTop() - 10;// 调节标题垂直位置
        String title = imageTable.getTitle();
        graphics.drawString(title, x, y);
        // 写入表头
        font = new Font("微软雅黑", Font.PLAIN, 16);
        graphics.setFont(font);
        Cell[] headCells = imageTable.getHeadCells();
        x = imageTable.getLeft() + 5;
        y = imageTable.getRowHeightArray()[0] + y;
        for (int m = 0; m < headCells.length; m++) {
            graphics.drawString(headCells[m].getContent().toString(), x+headCells[m].getX(),
                    y);
            x = imageTable.getColumnWidthArray()[m] + x;
        }
        // 设置字体
        font = new Font("微软雅黑", Font.PLAIN, 14);
        graphics.setFont(font);
        Cell[][] cells = imageTable.getCells();

        // 写入内容
        for (int n = 0; n < cells.length; n++) {
            x = imageTable.getLeft() + 10;
            y = y + imageTable.getRowHeightArray()[n + 1];
            Cell[] arr = cells[n];
            for (int l = 0; l < arr.length; l++) {
                Cell cell = cells[n][l];
                graphics.setColor(fontColor);
                graphics.drawString(cell.getContent().toString(), x, y);
                x = x + imageTable.getColumnWidthArray()[l];
                //箭头绘制
                if (cells[n][l].getArrow() != null) {
                    drawArrow(graphics, x - 18, y, cell.getArrow());
                }
            }
        }
    }

    private void drawArrow(Graphics graphics, int x, int y, Arrow arrow) {
        switch (arrow) {
            case UP:
                graphics.setColor(arrow.getColor());
                drawUpArrow(graphics, x, y - 10);
                break;
            case DOWN:
                graphics.setColor(arrow.getColor());
                drawDownArrow(graphics, x, y);
                break;
            case RIGHT:
                graphics.setColor(arrow.getColor());
                drawRightArrow(graphics, x, y);
                break;
            default:
                break;
        }
    }

    public void commonGraphicsGeneration(ImageTable imageTable) throws IOException {
        // 图片尺寸
        int imageWidth = imageTable.getImageWidth();
        int imageHeight = imageTable.getImageHeight();

        // 颜色
        Color bgColor = new Color(255, 255, 255);// 背景颜色
        Color lineColor = new Color(170, 170, 170);// 表格边框条颜色
        Color fontColor = Color.BLACK;// 默认字体颜色
        Graphics graphics = null;
        if (imageTable.getBgImage() != null) {
            image = ImageIO.read(new FileInputStream(new File(imageTable.getBgImage())));
            graphics = image.getGraphics();
        } else {
            image = new BufferedImage(imageWidth, imageHeight,
                    BufferedImage.TYPE_INT_RGB);
            graphics = image.getGraphics();
            // 设置背景色
            graphics.setColor(bgColor);
            graphics.fillRect(0, 0, imageWidth, imageHeight);
        }
        //绘制表格边框
        graphics.setColor(lineColor);
        drawTable(imageTable, graphics);
        //
        drawContent(graphics, fontColor, imageTable);

        createImage("e:\\image\\first.jpg");
    }

    public static void main(String[] args) throws Exception {
        ImageEngine cg = new ImageEngine();
        ImageTable.Builder builder = new ImageTable.Builder();
        builder.imageWidth(380).imageHeight(200)
                .columnWidthArray(80, 90, 90, 0).rowHeightArray(0, 0, 0, 0)
                .top(30).bottom(10).left(20).right(20).bgImage("e:\\image\\bg8.png");
        //String[] headCells = {"指标", "当日", "当年累计", "同比"};
        Cell[] headCells= new Cell[4];
        headCells[0]=new Cell("指标",20,0);
        headCells[1]=new Cell("当日",20,0);
        headCells[2]=new Cell("当年累计",10,0);
        headCells[3]=new Cell("同比",20,0);
        builder.headCells(headCells);
        builder.title("上海2017/1/11快报");
        String[][] cellsValue = {{"报案(件)", "27964", "322672", "-359993"},
                {"赔付(万元)", "19715", "190122", "329999"},
                {"未决(件)", "605291", "-", "-299991"}};
        Cell[][] cells = new Cell[cellsValue.length][];
        for (int i = 0; i < cellsValue.length; i++) {
            cells[i] = new Cell[cellsValue[i].length];
            for (int j = 0; j < cellsValue[i].length; j++) {
                if (j == 3) {
                    String value = cellsValue[i][j];
                    int v = Integer.parseInt(value);
                    if (v > 0) {
                        cells[i][j] = new Cell(cellsValue[i][j], null);
                        cells[i][j].setArrow(Arrow.UP);
                        cells[i][j].setArrowColor(new Color(238, 74, 87));
                    } else {
                        Integer abs = Math.abs(v);
                        cells[i][j] = new Cell(abs.toString(), null);
                        cells[i][j].setArrow(Arrow.DOWN);
                        cells[i][j].setArrowColor( new Color(2, 148, 115));
                    }
                } else {
                    cells[i][j] = new Cell(cellsValue[i][j], null);
                }
            }
        }
        builder.cells(cells);
        ImageTable imageTable = builder.build();
        cg.commonGraphicsGeneration(imageTable);
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}