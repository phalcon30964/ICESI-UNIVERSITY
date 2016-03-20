package control;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * @author Easy Task Admin
 * 
 */

public class AdminEmail {

	static Properties mailServerProperties;
	static Session getMailSession;
	public static MimeMessage msg;
	static String sourceEmail = "easytaskenterprise@gmail.com";
	static String password = "easytask123";

	public static void main(String args[]) throws AddressException, MessagingException {

		System.out.println("\n1st ===> setup Mail Server Properties..");

//		final String sourceEmail = "easytaskenterprise@gmail.com"; // requires valid Gmail id
//		final String password = "easytask123"; // correct password for Gmail id
//		final String toEmail = "delgado.diego.e@gmail.com"; // any destination email id

//		Properties props = new Properties();
//		props.put("mail.smtp.host", "smtp.gmail.com");
//		props.put("mail.smtp.port", "587");
//		props.put("mail.smtp.auth", "true");
//		props.put("mail.smtp.starttls.enable", "true");

		System.out
		.println("\n2nd ===> create Authenticator object to pass in Session.getInstance argument..");

//		Authenticator authentication = new Authenticator() {
//			protected PasswordAuthentication getPasswordAuthentication() {
//				return new PasswordAuthentication(sourceEmail, password);
//			}
//		};
//		Session session = Session.getInstance(props, authentication);
//		generateAndSendEmail(
//				session,
//				toEmail,
//				"Prueba de Correo! ",
//				"Greetings, <br><br>Si se puede! :D  Please find here attached Image."
//						+ "<br><br> Regards, <br>EasyTask Admin");
	
	generateAndSendEmail("delgado.diego.e@gmail.com","Welcome to Easy Task"  ,
			"Greetings, <br><br>Thanks for choosing Us ! :D  Please find here attached Image."
			+ "<br><br> Regards, <br>EasyTask Admin");	
		
	}

	public static void generateAndSendEmail(String toEmail, String subject,
			String body) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		
		Authenticator authentication = new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sourceEmail, password);
			}
		};
		Session session = Session.getInstance(props, authentication);
		
		try {
			System.out.println("\n3rd ===> generateAndSendEmail() starts..");

			MimeMessage message = new MimeMessage(session);
			message.addHeader("Content-type", "text/HTML; charset=UTF-8");
			message.addHeader("format", "flowed");
			message.addHeader("Content-Transfer-Encoding", "8bit");

			message.setFrom(new InternetAddress(toEmail,"Easy Task Enterprise"));
			message.setReplyTo(InternetAddress.parse("easytaskenterprise@gmail.com", false));
			message.setSubject(subject, "UTF-8");
			message.setSentDate(new Date());
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(toEmail, false));

			// Create the message body part
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(body, "text/html");

			// Create a multipart message for attachment
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			messageBodyPart = new MimeBodyPart();

			// Valid file location
			String filename = "../Generate/src/img/logo.png";
			DataSource source = new FileDataSource(filename);
			messageBodyPart.setDataHandler(new DataHandler(source));
			messageBodyPart.setFileName(filename);
			// Trick is to add the content-id header here
			messageBodyPart.setHeader("Content-ID", "image_id");
			multipart.addBodyPart(messageBodyPart);

			System.out.println("\n4th ===> third part for displaying image in the email body..");
			messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("<br><h3>Thanks, </h3>"
					+ "<img src='cid:image_id'>", "text/html");
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);

			System.out.println("\n5th ===> Finally Send message..");

			// Finally Send message
			Transport.send(message);

			System.out
			.println("\n6th ===> Email Sent Successfully With Image Attachment. Check your email now..");
			System.out.println("\n7th ===> generateAndSendEmail() ends..");

		} catch (MessagingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}