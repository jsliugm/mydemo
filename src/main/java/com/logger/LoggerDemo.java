package com.logger;

import java.io.File;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerDemo {

	protected Logger log = Logger.getLogger(this.getClass().getName());

	public LoggerDemo() {
	}

	public void setHandler(Handler handler) {
		this.log.addHandler(handler);
	}

	public int add(int a, int b) {
		int result = a + b;
		String l = a + " + " + b + " = " + result;
		log.log(Level.FINEST, l); // *1
		log.info(l);
		//System.out.print(this.getClass().getName());
		return result;
	}

	public static void main(String[] args) {
		try {
			//Logger logg = Logger.getLogger("com.sample.LoggerSample");// *2
		//	logg.setLevel(Level.INFO);// *3

			File f = new File("C:/logger/log.log");
			if (!f.exists()) {
				new File("C:/logger").mkdir();
			}

			FileHandler fh = new FileHandler(f.toString());// *4
			fh.setFormatter(new SimpleFormatter());

			// ConsoleHandler ch=new ConsoleHandler();
			// ch.setLevel(Level.ALL);

			LoggerDemo ls = new LoggerDemo();
			ls.setHandler(fh);
			ls.add(1, 2);
			fh.close();
		} catch (Exception e) {
			System.out.println("Exception thrown: " + e);
			e.printStackTrace();
		}
	}
}
