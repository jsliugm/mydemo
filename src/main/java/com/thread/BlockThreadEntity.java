package com.thread;

import lombok.Data;

import java.lang.management.LockInfo;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.ArrayList;
import java.util.List;
@Data
public class BlockThreadEntity {
    private String threadId;
    private String lockInfo;
    private String stackTrace;
    private String threadName;

    public static List<BlockThreadEntity> getBlockThreadList() {
        List<BlockThreadEntity> blockThreadInfoList = new ArrayList<>();
        final ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadBean.dumpAllThreads(false, false);

        if (threadInfos != null) {
            for (ThreadInfo threadInfo : threadInfos) {
                BlockThreadEntity entity = null;
                if (Thread.State.BLOCKED.equals(threadInfo.getThreadState())) {
                    entity = new BlockThreadEntity();
                    StringBuffer sb = new StringBuffer();
                    StackTraceElement[] stack = threadInfo.getStackTrace();
                    LockInfo lockInfo = threadInfo.getLockInfo();
                    String lockInfoString = null != lockInfo ? lockInfo.getClassName() : "";
                    for (StackTraceElement stackTraceElement : stack) {
                        sb.append("\n" + stackTraceElement.toString());
                    }
                    //记录阻塞线程信息
                    entity.lockInfo = lockInfoString;
                    entity.stackTrace = sb.toString();
                    entity.threadId = String.valueOf(threadInfo.getThreadId());
                    entity.threadName = threadInfo.getThreadName();
                }
                if (entity != null) {
                    blockThreadInfoList.add(entity);
                }
            }
        }
        return blockThreadInfoList;
    }
}
