package com.quartz.gpt;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class QuartzExample {
    public static void main(String[] args) {
        try {
            // 创建调度器
            SchedulerFactory schedulerFactory = new StdSchedulerFactory();
            Scheduler scheduler = schedulerFactory.getScheduler();

            // 定义作业细节
            JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                                            .withIdentity("helloJob", "group1")
                                            .build();

            // 定义触发器，每5秒执行一次
            Trigger trigger = TriggerBuilder.newTrigger()
                                            .withIdentity("trigger1", "group1")
                                            .startNow()
                                            .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                                                .withIntervalInSeconds(5)
                                                .repeatForever())
                                            .build();

            // 将作业和触发器注册到调度器
            scheduler.scheduleJob(jobDetail, trigger);

            // 启动调度器
            scheduler.start();

            // 运行一段时间后关闭调度器
            Thread.sleep(30000);
            scheduler.shutdown(true);

        } catch (SchedulerException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
