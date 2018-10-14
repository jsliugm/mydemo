package com.swing;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
//import javax.swing.JMenuItem;

public class SwingDemo {
	private JFrame frame;
	//private JMenuBar jmb;
	
	public void init() {
		frame= new JFrame();
		JMenuBar jMenuBar = new JMenuBar();
		jMenuBar.add(new JMenu());
		jMenuBar.setSize(200,200);
		frame.setJMenuBar(jMenuBar);
		frame.setSize(400, 400);
		frame.setVisible(true);
		frame.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent e) {

			}

			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}

			public void windowClosed(WindowEvent e) {

			}

			public void windowIconified(WindowEvent e) {

			}

			public void windowDeiconified(WindowEvent e) {

			}

			public void windowActivated(WindowEvent e) {

			}

			public void windowDeactivated(WindowEvent e) {

			}
		});
	}
	public static void main(String[] args) {
		SwingDemo sd = new SwingDemo();
		sd.init();
	}
}
