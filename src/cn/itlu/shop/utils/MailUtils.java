package cn.itlu.shop.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/*
 * 邮件发送工具类
 */
public class MailUtils {
	/*
	 * 发送邮件的方法
	 * to:     收件人
	 * code：      激活码
	 */
	public static void sendMail(String to,String code){
		/*
		 * 1、获得一个session对象
		 * 2、创建一个代表邮件的对象Message
		 * 3、发送邮件
		 */
		//1、获取连接对象
		Properties props = new Properties();
		props.setProperty("mail.host", "localhost");
		Session session = Session.getInstance(props, new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("service@shop.com", "111");
			}
			
		})  ;
		//2、创建邮件对象；
		Message message = new MimeMessage(session);
		
		try {
			//设置发送人
			message.setFrom(new InternetAddress("service@shop.com"));
			//设设置收件人
			message.addRecipient(RecipientType.TO,new InternetAddress(to));
			//抄送CC 密送BCC
			//设置标题
			message.setSubject("来之卢的激活邮件");
			//设置邮件正文
			message.setContent("<h1>购物天堂官方激活文件！点击链接完成激活操作</h1><h3><a href='http://192.168.0.107:8080/ssh_shop/user_active.action?code="+code+"'>http:// 192.168.0.107:8080/shop/usser_active.action?code="+code+"</a></h3>", "text/html;charset=utf-8");
			//发送邮件
			Transport.send(message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
public static void main(String[] args) {
	sendMail("aaa@shop.com", "000000000");
}
}

