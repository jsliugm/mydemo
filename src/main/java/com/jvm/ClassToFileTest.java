package com.jvm;

import org.codehaus.groovy.control.CompilerConfiguration;
import org.codehaus.groovy.tools.FileSystemCompiler;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;

public class ClassToFileTest {
    private static String sourceDir = "/groovy/script/";
    private static String compiledDir = "/groovy/script/compiled/";

    @Test
    public void compileGroovy() throws Exception {
        File dir = new File(sourceDir);
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().endsWith(".groovy")) {
                    return true;
                }
                return false;
            }
        });
        // 创建编译配置
        CompilerConfiguration config = new CompilerConfiguration();
        config.setTargetDirectory(compiledDir);
        // 编译Groovy脚本并将字节码写入目标路径
        FileSystemCompiler compiler = new FileSystemCompiler(config);
        compiler.compile(files);
    }


    @Test
    public void writeClassToRedis() {
        File dir = new File(compiledDir);
        File[] files = dir.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.getName().endsWith(".class")) {
                    return true;
                }
                return false;
            }
        });
        for (File file : files) {
            try {
                RedisUtils.set(file.getName(), Files.readAllBytes(file.toPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
