package com.quartz;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by jsliu on 2019/11/13.
 */
@Slf4j
public class QuartzDemo {
    public static void main(String[] args) throws Exception {
        cronTest();
    }
    /**
     * cronSchedule 测试
     */
    public static void cronTest() throws Exception {
        // 1、创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class)
                .withIdentity("cronJob", "group").build();
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("cronTrigger", "cronTriggerGroup")
                .usingJobData("cronTrigger", "这是jobDetail1的trigger")
                .startNow()//立即生效
      /*          .startAt(new Date())
                .endAt(endDate)*/
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0/5 * * * ?"))
                .build();
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
    }

    public static void test() throws SchedulerException, InterruptedException {

        // 1、创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail1 = JobBuilder.newJob(PrintWordsJob2.class)
                .withIdentity("job1", "group1").build();

        // 3、构建Trigger实例,每隔1s执行一次
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "triggerGroup1")
                .startNow()//立即生效
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(1)//每隔1s执行一次
                        .repeatForever()).build();//一直执行

        //4、执行
        scheduler.scheduleJob(jobDetail1, trigger);
       // scheduler.unscheduleJob(trigger);
        System.out.println("--------scheduler start ! ------------");
        scheduler.start();

        Thread stopThread = new Thread(new Runnable() {
            @Override
            public void run() {
                log.info("stopThread start...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                JobKey jobKey = new JobKey("job1", "group1");
                try {
                    //scheduler.deleteJob(jobKey);
                    //log.info("delete job success!!!");
                    log.info(scheduler.getTriggerState(TriggerKey.triggerKey("trigger1", "triggerGroup1")).toString());
                } catch (SchedulerException e) {
                    e.printStackTrace();
                }
            }
        });
        stopThread.start();
        //睡眠
        /*TimeUnit.MINUTES.sleep(1);
        scheduler.shutdown();
        System.out.println("--------scheduler shutdown ! ------------");*/
    }
}