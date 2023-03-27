package com.email;

import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.junit.Test;

/**
 * 使用Apache Commons Email发送邮件
 */
public class CommonsEmailTest {
    /**
     * 发送内容为简单文本的邮件
     */
    @Test
    public void sendSimpleTextEmail() throws EmailException {
       // 发送简单的email,不能添加附件
       Email email = new SimpleEmail();

       // 邮件服务器域名
       email.setHostName("smtp.qiye.163.com");
       // 邮件服务器smtp协议的SSL端口
       email.setSmtpPort(465);
       // 用户名和密码为邮箱的账号和密码
       email.setAuthenticator(new DefaultAuthenticator("liuguangming@taijihuabao.com", "Bobo0426@"));
       // SSL安全连接
       email.setSSLOnConnect(true);
       // 设置字符编码方式
       email.setCharset("UTF-8");
       // 发件人
       email.setFrom("liuguangming@taijihuabao.com");
       // 收件人
       email.addTo("jsliugm@163.com");
//     email.addTo(String... emails);//发送给多人
//     // 抄送
//     email.addCc("xxx");
//     // 密送
//     email.addBcc("xxx");
       // 邮件主题
       email.setSubject("测试邮件");
       // 邮件正文
       email.setMsg("这是一封测试邮件!");
       // 发送
       email.send();
    }

    /**
     * 发送包含附件的邮件（附件为本地资源）
     */
    @Test
    public void sendEmailsWithAttachments() throws EmailException {
       // 附件类，可以添加本地资源，也可以指定网络上资源，在发送时自动将网络上资源下载发送
       EmailAttachment attachment = new EmailAttachment();
       // 本地路径
       attachment.setPath("D:\\test\\java265.jpg");
       // 定义附件
       attachment.setDisposition(EmailAttachment.ATTACHMENT);
       // 附件描述
       attachment.setDescription("Picture");
       // 附件名（为中文时要处理编码）
       attachment.setName("pic.jpg");
       // 文本邮件，可以添加多个附件
       MultiPartEmail email = new MultiPartEmail();

       email.setHostName("smtp.163.com");
       email.setAuthentication("用户名", "密码");
       email.setFrom("xxx@163.com");
       email.addTo("xxx@163.com");
       email.setSubject("测试邮件");
       email.setMsg("测试邮件的正文内容！");
       email.attach(attachment);
       email.send();
    }


    /**
     * 发送包含附件的邮件（附件为在线资源）
     */
    @Test
    public void sendEmailsWithOnlineAttachments() throws EmailException, MalformedURLException {
       EmailAttachment attachment = new EmailAttachment();
       attachment.setURL(new URL("https://www.baidu.com/img/bd_logo1.png"));
       attachment.setDisposition(EmailAttachment.ATTACHMENT);
       attachment.setDescription("Baidu logo");
       attachment.setName("Baidu.png");
       MultiPartEmail email = new MultiPartEmail();
       email.setHostName("smtp.163.com");
       email.setAuthentication("用户名", "密码");
       email.setFrom("xxx@163.com");
       email.addTo("xxx@163.com");
       email.setSubject("测试邮件");
       email.setMsg("发送的图片是一个网站的logo");
       email.attach(attachment);
       email.send();
    }

    /**
     * 发送内容为HTML格式的邮件,内嵌图片
     */
    @Test
    public void sendHTMLFormattedEmail() throws EmailException, MalformedURLException {
       // HTML格式邮件，同时具有MultiPartEmail类所有“功能”
       HtmlEmail email = new HtmlEmail();
       email.setHostName("smtp.163.com");
       email.setAuthentication("用户名", "密码");
       email.setFrom("xxx@163.com");
       email.addTo("xxx@163.com");
       email.setSubject("测试邮件");
       // 图片的网络地址
       URL url = new URL("https://www.baidu.com/img/bd_logo1.png");
       String cid = email.embed(url, "Baidu logo");
       // 将图片引入html标签
       email.setHtmlMsg("<html>这是百度的logo<br/><img src='cid:" + cid + "'></html>");
       email.send();
    }

    /**
     * 发送内容为HTML格式的邮件,内嵌图片
     */

    @Test
    public void sendHTMLFormattedEmailWithEmbeddedImages() throws MalformedURLException, EmailException {
       // ImageHtmlEmail类通常是用来发送Html格式并内嵌图片的邮件
	   //它拥有所有HtmlEmail的功能，但是图片主要是以html内嵌的为主
       ImageHtmlEmail email = new ImageHtmlEmail();
       email.setHostName("smtp.163.com");
       email.setSmtpPort(456);
       email.setSSLOnConnect(true);
       email.setAuthentication("用户名", "密码");
       email.setFrom("xxx@163.com");
       email.addTo("xxx@163.com");
       email.setCharset("UTF-8");
       email.setSubject("测试邮件");
       URL url = new URL("https://www.baidu.com");
       // 这样HTML内容里如果有此路径下的图片会直接内联
       email.setDataSourceResolver(new DataSourceUrlResolver(url));
       String htmlEmail = "这里<img src='https://www.baidu.com/img/bd_logo1.png'>有图片。";
       email.setHtmlMsg(htmlEmail);
       email.send();
    }
}
