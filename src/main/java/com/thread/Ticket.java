package com.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    public static Long ticketNum = 100L;

//    public Ticket(Long num) {
//        this.ticketNum = num;
//    }

    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
		//System.out.printf("%s启动...\n",Thread.currentThread().getName());
        while (ticketNum > 0) {
            //synchronized (this) {
			try {
				Thread.sleep(100L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.lock();
            try {
                if (ticketNum > 0) {
                    //System.out.printf("%s，剩余：%3d\n", Thread.currentThread().getName(), ticketNum);
                    ticketNum--;
                }

            } finally {
                lock.unlock();
            }
            //}
        }
    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i = 0; i < 2; i++) {
            new Thread(ticket, "窗口" + i).start();
        }
    }
}
