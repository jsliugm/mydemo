package com.rename;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //指定路径
        String path = "E:\\downloads\\src\\韩国演艺圈卖淫偷拍悲惨事件合集";
        //获取文件列表
        //遍历文件
        File dir = new File(path);
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            //重命名策略
            File itemFile = files[i];
            String newName = getNewName(itemFile.getName());
            if (newName != null) {
                itemFile.renameTo(new File(path + File.separator + newName));
            }
        }
    }

    /**
     * 抽取文件名中的数字并返回
     *
     * @param fileName
     * @return
     */
    private static String getNewName(String fileName) {
        Pattern p = Pattern.compile("(\\d+).");
        Matcher matcher = p.matcher(fileName);
        boolean hit = matcher.find();
        if (hit) {
            return matcher.group();
        }
        return null;
    }
}
