package com.jsch;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import com.sftp.SFTPChannel;
import com.sftp.SFTPConstants;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

/**
 * Created by dell on 2017/9/10.
 */
public class JschDemo {
    private final static Logger logger = Logger.getLogger(JschDemo.class);
    SFTPChannel sftpChannel;
    ChannelSftp channelSftp;

    @Before
    public void pre() {
        Map<String, String> sftpDetails = new HashMap<String, String>();
        // 设置主机ip，端口，用户名，密码
        sftpDetails.put(SFTPConstants.SFTP_REQ_HOST, "192.168.61.128");
        sftpDetails.put(SFTPConstants.SFTP_REQ_USERNAME, "xxxapp");
        sftpDetails.put(SFTPConstants.SFTP_REQ_PASSWORD, "linux");
        sftpDetails.put(SFTPConstants.SFTP_REQ_PORT, "22");
        sftpChannel = new SFTPChannel();
        try {
            channelSftp = sftpChannel.getChannel(sftpDetails, 60000);
        } catch (JSchException e) {
            e.printStackTrace();
            logger.error(e);
        }
    }

    @Test
    public void test() throws Exception {

        channelSftp.cd("/home/xxxapp");
        //chSftp.mkdir("test0910");
        //System.out.println(chSftp.lpwd());
        Vector<ChannelSftp.LsEntry> vector = channelSftp.ls(channelSftp.pwd());
        //chsftp.
        //Iterator<String> iterator= vector.iterator();
        for (Iterator<ChannelSftp.LsEntry> iterator = vector.iterator(); iterator.hasNext(); ) {
            ChannelSftp.LsEntry lsEntry = iterator.next();
            System.out.println(lsEntry.getFilename());
        }
        /**
         * 代码段1
         OutputStream out = chSftp.put(dst, ChannelSftp.OVERWRITE); // 使用OVERWRITE模式
         byte[] buff = new byte[1024 * 256]; // 设定每次传输的数据块大小为256KB
         int read;
         if (out != null) {
         System.out.println("Start to read input stream");
         InputStream is = new FileInputStream(src);
         do {
         read = is.read(buff, 0, buff.length);
         if (read > 0) {
         out.write(buff, 0, read);
         }
         out.flush();
         } while (read >= 0);
         System.out.println("input stream read done.");
         }
         **/

        //chSftp.put(src, dst, ChannelSftp.OVERWRITE); // 代码段2

        // chSftp.put(new FileInputStream(src), dst, ChannelSftp.OVERWRITE); // 代码段3


    }

    /**
     * 检查目录或者文件是否存在
     * @param channelSftp
     * @param directoryOrFilePath
     * @return
     */
    public static boolean checkExists(ChannelSftp channelSftp, String directoryOrFilePath) {
        try {
            Vector<ChannelSftp.LsEntry> vector = channelSftp.ls(directoryOrFilePath);
            for (Iterator<ChannelSftp.LsEntry> iterator = vector.iterator(); iterator.hasNext(); ) {
                ChannelSftp.LsEntry lsEntry = iterator.next();
                return true;
            }
        } catch (SftpException e) {
            logger.error(e);
            e.printStackTrace();
        }catch (Throwable e){
            logger.error(e);
        }
        return false;
    }
    @Test
    public void testMkdir() throws SftpException {
        String path = "/home/xxxapp/abc/0910";
    }
    @Test
    public void testLs() throws SftpException {
        String path = "/home/xxxapp/test0910/success.txt";
        boolean result = checkExists(channelSftp,path);
        System.out.println(result);
        if(result){
            channelSftp.get(path,"e:\\");
        }
    }

    @After
    public void destroy() {
        channelSftp.quit();
        try {
            sftpChannel.closeChannel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
