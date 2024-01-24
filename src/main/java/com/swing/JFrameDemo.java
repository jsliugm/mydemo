package com.swing;

import javax.swing.*;
import java.awt.*;

/**
 * @author jsliu
 */
public class JFrameDemo extends JFrame {
    public JFrameDemo() {
        setTitle("first gui");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel jl = new JLabel("这是使用JFrame类创建的窗口");
        Container c = getContentPane();
        c.add(jl);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JFrameDemo();
    }
}
