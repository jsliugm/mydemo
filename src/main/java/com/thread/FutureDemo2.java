package com.thread;


import org.springframework.util.StopWatch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.*;

/**
 * @program: MyDemo
 * @description: future demo
 * @author: guangming.liu
 * @create: 2018-09-26 08:47
 **/
public class FutureDemo2 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        FutureTask<Boolean> futureTask = new FutureTask<>(
                new Callable<Boolean>() {
                    @Override
                    public Boolean call() throws Exception {
                        /*System.out.println("不告诉你。");
                        Thread.sleep(1000 * 3);
                        System.out.println("8888888888");*/
                        boolean flag = true;
                        while(flag){
                            System.out.println(System.currentTimeMillis());
                        }
                        return false;
                    }
                });
        try {
            executorService.submit(futureTask).get(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TimeoutException e) {
            System.out.println("超时了吧~~~");
            e.printStackTrace();
            executorService.shutdownNow();
        }
    }
    public static void writeFile(String fileName, String content){
        FileWriter output = null;
        BufferedWriter writer = null;
        try{
            output = new FileWriter(fileName);
            writer = new BufferedWriter(output);
            writer.write(content);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(null != writer){
                try {
                    writer.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(null != output){
                try {
                    output.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}