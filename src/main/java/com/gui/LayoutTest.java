package com.gui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;

public class LayoutTest {
    public static void main(String[] args) {
        new LayoutFrame().init();
    }
}

class LayoutFrame extends Frame {
    void init() {
        setBounds(100, 100, 300, 400);
        Button btn1 = new Button("btn1");
        Button btn2 = new Button("btn2");
        Button btn3 = new Button("btn3");
        Button btn4 = new Button("btn4");
        setLayout(new FlowLayout());
        add(btn1);
        add(btn2);
        add(btn3);
        add(btn4);
        pack();
        setVisible(true);
    }
}
