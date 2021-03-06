package cn.hyj.web.util;
 
import java.util.Properties;  
  

import javax.mail.Message;

import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
 
import javax.mail.internet.MimeMessage;  
  
/** 
 * 发送邮件的测试程序(适用qq邮箱) 
 * 通过本人的qq邮箱: xxx@qq.com 发送邮件 
 * @author miaoch 
 *  
 */  
public class sendMail {  
  
	public static void sendMail() throws Exception {
		Properties props = new Properties();//key value:配置参数。真正发送邮件时再配置
        props.setProperty("mail.transport.protocol", "smtp");//指定邮件发送的协议，参数是规范规定的
        props.setProperty("mail.host", "smtp.qq.com");//指定发件服务器的地址，参数是规范规定的
//        props.setProperty("mail.debug", "true");//邮件发送的调试模式，参数是规范规定的
        props.setProperty("mail.smtp.auth", "true");//请求服务器进行身份认证。参数与具体的JavaMail实现有关
        
        Session session = Session.getInstance(props);//发送邮件时使用的环境配置
        session.setDebug(true);
        MimeMessage message = new MimeMessage(session);
        
        //设置邮件的头
        message.setFrom(new InternetAddress("1296698997@qq.com"));
        message.setRecipients(Message.RecipientType.TO, "1296698997@qq.com");
        message.setSubject("提醒");
        //设置正文
        message.setText("你登陆了医院管理系统");//纯文本
        
        message.saveChanges();
        
        //发送邮件
        Transport ts = session.getTransport();
        ts.connect("1296698997@qq.com", "eseavejzhbjcijcd");       // 密码为授权码不是邮箱的登录密码
        ts.sendMessage(message, message.getAllRecipients());//对象，用实例方法}
	}

}