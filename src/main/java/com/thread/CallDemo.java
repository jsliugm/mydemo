package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CallDemo {

	public static void main(String[] args) {
		Callable oneCallable = new Call();
		FutureTask<String> oneTask = new FutureTask<String>(oneCallable);
		Thread oneThread = new Thread(oneTask);
		oneThread.start();
		System.out.println(Thread.currentThread());
		 ExecutorService pool =Executors.newCachedThreadPool();
		 pool.submit(oneCallable);
		 pool.shutdown();
		 System.out.println(CallDemo.class.getName());
	}

}

class Call implements Callable<String> {
	public String call() throws Exception {
		System.out.println(Thread.currentThread());
		return "aaaaa";
	}

}
