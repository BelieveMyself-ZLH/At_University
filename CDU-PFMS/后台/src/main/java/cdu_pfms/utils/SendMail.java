<<<<<<< HEAD
package cdu_pfms.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件的工具类
 * @author ZhouLinHu
 * @createTime 2018年11月9日 下午3:31:04
 * @lastTime 2018年11月9日 下午3:31:04
 * @version 1.0.0
 */
public class SendMail {
	private static String myEmailAccount="mailbox_of_zlh@163.com";
	private static String myEmailPassword="ABC123";
	private static String myEmailSMTPHost="smtp.163.com";
	
	/**
	 * 封装发送邮件方法
	 * @param receiveMail	收件邮箱
	 * @param subject	邮件主题
	 * @param content	邮件内容
	 * @param account	收件人
	 */
	public void sendEmail(String receiveMail, String subject, String content, String account) {
		Properties props=new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", myEmailSMTPHost);
		props.setProperty("mail.smtp.auth", "true");
		Session session=Session.getInstance(props);
		session.setDebug(true);
		try {
			MimeMessage message=createEmail(session, receiveMail, subject, content, account);
			Transport transport=session.getTransport();
			transport.connect(myEmailAccount, myEmailPassword);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 创建一封邮件
	 * @param session
	 * @param sendMail
	 * @param receiveMail
	 * @return
	 * @throws Exception
	 */
	private MimeMessage createEmail(Session session, String receiveMail, String subject, String content, String userName) throws Exception {
		MimeMessage message=new MimeMessage(session);
		message.setFrom(new InternetAddress(myEmailAccount, "橙子资金管理系统", "UTF-8"));
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, userName, "UTF-8"));
		message.setSubject(subject,"UTF-8");
		message.setContent(content, "text/html;charset=UTF-8");
		message.setSentDate(new Date());
		message.saveChanges();
		return message;
	}
}
=======
package cdu_pfms.utils;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 发送邮件的工具类
 * @author ZhouLinHu
 * @createTime 2018年11月9日 下午3:31:04
 * @lastTime 2018年11月9日 下午3:31:04
 * @version 1.0.0
 */
public class SendMail {
	private static String myEmailAccount="mailbox_of_zlh@163.com";
	private static String myEmailPassword="ABC123";
	private static String myEmailSMTPHost="smtp.163.com";
	
	/**
	 * 封装发送邮件方法
	 * @param receiveMail	收件邮箱
	 * @param subject	邮件主题
	 * @param content	邮件内容
	 * @param account	收件人
	 */
	public void sendEmail(String receiveMail, String subject, String content, String account) {
		Properties props=new Properties();
		props.setProperty("mail.transport.protocol", "smtp");
		props.setProperty("mail.smtp.host", myEmailSMTPHost);
		props.setProperty("mail.smtp.auth", "true");
		Session session=Session.getInstance(props);
		session.setDebug(true);
		try {
			MimeMessage message=createEmail(session, receiveMail, subject, content, account);
			Transport transport=session.getTransport();
			transport.connect(myEmailAccount, myEmailPassword);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 创建一封邮件
	 * @param session
	 * @param sendMail
	 * @param receiveMail
	 * @return
	 * @throws Exception
	 */
	private MimeMessage createEmail(Session session, String receiveMail, String subject, String content, String userName) throws Exception {
		MimeMessage message=new MimeMessage(session);
		message.setFrom(new InternetAddress(myEmailAccount, "橙子资金管理系统", "UTF-8"));
		message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, userName, "UTF-8"));
		message.setSubject(subject,"UTF-8");
		message.setContent(content, "text/html;charset=UTF-8");
		message.setSentDate(new Date());
		message.saveChanges();
		return message;
	}
}
>>>>>>> second commit
