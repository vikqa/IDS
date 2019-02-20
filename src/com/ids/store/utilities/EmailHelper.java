//package  com.ids.store.utilities;
//
//import java.io.UnsupportedEncodingException;
//import java.util.*;
//
//import javax.activation.DataHandler;
//import javax.activation.DataSource;
//import javax.activation.FileDataSource;
//import javax.mail.BodyPart;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.Multipart;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;
//
//import org.apache.log4j.Logger;
//
//import com.ids.store.common.Common;
//
//
//
//public class EmailHelper {
//	final static Logger logger = Logger.getLogger(EmailHelper.class);
//	String user;
//	String password;
//
//	public void sendMailToManagement() {
//		ArrayList<String> arr = ReadWritePropertiesFile.getMailProperties();
//		String toList = arr.get(1);
//		String[] to = Common.stringSepratedByComma(toList);
//		user = arr.get(2);
//		String username = arr.get(3);
//		password = arr.get(4);
//		String subject = arr.get(5);	
//		String filename = arr.get(8);
//		String filePath = arr.get(9);
//		String host = arr.get(10);		
//		ArrayList<String> arrMail = ReadWritePropertiesFile.getMailRunTimeProperties();		
//		String startTime = arrMail.get(0);
//		String endTime = Common.getCurrentDateTime("yyyy-MM-dd HH:mm:ss");
//		String url = arrMail.get(1);
//		String env = arrMail.get(2);
//		String build = ReadWritePropertiesFile.getTestLinkProperty("TestLinkBuild");
//		
//		String currentDate = Common.getCurrentDate();
//		
//		subject += " "+currentDate+" Build No-"+build;
//		String msg = "Hi Team, \n\nPlease find the attached Ids automation test execution report: \n\nStart Date: "+startTime+"\nEnd Date: "+endTime+"\nURL: "+url+"\nEnvironment Details: "+env+"\n\nKind Regards\n GUI Automation Team";
//		Properties properties = System.getProperties();
//		properties.setProperty("mail.smtp.host", host);
//		properties.put("mail.smtp.auth", "true");
//		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(user, password);
//			}
//		});
//		try {
//			MimeMessage message = new MimeMessage(session);
//			try {
//				message.setFrom(new InternetAddress(user, username));
//			} catch (UnsupportedEncodingException e) {
//				logger.info("Issue in username settings", e);
//				e.printStackTrace();
//			}
//			InternetAddress[] mailAddress = new InternetAddress[to.length];
//			for (int i = 0; i < mailAddress.length; i++)
//				mailAddress[i] = new InternetAddress(to[i]);
//			message.addRecipients(Message.RecipientType.TO, mailAddress);
//			message.addRecipients(Message.RecipientType.BCC, "vikas@ids.com");
//			message.setSubject(subject);
//			BodyPart messageBodyPart1 = new MimeBodyPart();
//			messageBodyPart1.setText(msg);
//			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
//			DataSource source = new FileDataSource(filePath);
//			messageBodyPart2.setDataHandler(new DataHandler(source));
//			messageBodyPart2.setFileName(filename);
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(messageBodyPart1);
//			multipart.addBodyPart(messageBodyPart2);
//			message.setContent(multipart);
//			Transport.send(message);
//		} catch (MessagingException ex) {
//			logger.info("Mail did not send to management ", ex);
//			ex.printStackTrace();
//		}
//
//	}
//
//	public void sendMailToUsers() {
//		ArrayList<String> arr = ReadWritePropertiesFile.getMailProperties();
//		String toList = arr.get(0);
//		String to = toList;
//		String user = arr.get(2);
//		String username = arr.get(3);
//		String password = arr.get(4);
//		String subject = arr.get(5);
//		String msg = arr.get(7);
//		String filename = arr.get(8);
//		String filePath = arr.get(9);
//		String host = arr.get(10);
//		Properties properties = System.getProperties();
//		properties.setProperty("mail.smtp.host", host);
//		properties.put("mail.smtp.auth", "true");
//		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(user, password);
//			}
//		});
//		try {
//			MimeMessage message = new MimeMessage(session);
//			try {
//				message.setFrom(new InternetAddress(user, username));
//			} catch (UnsupportedEncodingException e) {
//				logger.info("Issue in username settings", e);
//				e.printStackTrace();
//			}
//			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
//			message.setSubject(subject);
//			BodyPart messageBodyPart1 = new MimeBodyPart();
//			messageBodyPart1.setText(msg);
//			MimeBodyPart messageBodyPart2 = new MimeBodyPart();
//			DataSource source = new FileDataSource(filePath);
//			messageBodyPart2.setDataHandler(new DataHandler(source));
//			messageBodyPart2.setFileName(filename);
//			Multipart multipart = new MimeMultipart();
//			multipart.addBodyPart(messageBodyPart1);
//			multipart.addBodyPart(messageBodyPart2);
//			message.setContent(multipart);
//			Transport.send(message);
//		} catch (MessagingException ex) {
//			logger.info("Mail did not send to Users ", ex);
//			ex.printStackTrace();
//		}
//
//	}
//
//}
