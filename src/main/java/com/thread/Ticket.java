package com.thread;

public class Ticket implements Runnable {
	public Long ticketNum;

	public Ticket(Long num) {
		this.ticketNum = num;
	}

	public void run() {
		while (ticketNum > 0) {
			synchronized (this) {
				if (ticketNum > 0) {
					System.err.println(Thread.currentThread().getName() + ":剩余"
							+ ticketNum);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					ticketNum--;
				}
			}
		}
		System.err.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		Ticket ticket = new Ticket(10l);
		for (int i = 0; i < 10; i++) {
			new Thread(ticket, "窗口" + i).start();
		}
	}
}
