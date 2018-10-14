package com.process;

import java.io.IOException;

/**
 * Created by c_liuguangming on 2017/1/22.
 */
public class ProcessTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        String cmd = "cmd echo hello";
        Runtime r = Runtime.getRuntime();
        Process p = r.exec(cmd);
        int returnCode = p.waitFor();
        System.out.println(returnCode);
    }
}
