package com.io;

import org.junit.Test;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FileUtil {
    public static void bytes2File(byte[] bytes, String path) {
        try (FileOutputStream fos = new FileOutputStream(path);BufferedOutputStream bos = new BufferedOutputStream(fos);) {
            bos.write(bytes);
            bos.flush();
        }  catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static <T> T file2Object(String path){
        try(FileInputStream fis = new FileInputStream(path);ObjectInputStream objectInputStream = new ObjectInputStream(fis)) {
            return  (T)objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void close(Closeable c) {
        if (c != null) {
            try {
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static public String File2String(String path) {
        StringBuffer result = new StringBuffer();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            String tmp;
            while ((tmp = br.readLine()) != null) {
                result.append(tmp);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            close(br);
            close(fr);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String path = FileUtil.class.getResource("test.txt").getFile();
        String input = File2String(path);
        //System.out.println(input);
        String pattern = "magnet:";
        int i = 0;
        int j = 0;
        while (i > -1 && j > -1) {
            i = input.indexOf(pattern, 0);
            j = input.indexOf("<", i);
            if (i > 0 && j > 0) {
                System.out.println(input.substring(i, j));
                input = input.substring(j);
            }
            //System.out.println(input);
        }
    }

    @Test
    public void test() {
        File f = new File("c:\\tezts\\xx.txt");
        System.out.println(f.getParentFile().exists());
        System.out.println(f.getParent());
    }
}
