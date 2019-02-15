/***********************************************************************
                         Aricent Technologies Proprietary
 
This source code is the sole property of Aricent Technologies. Any form of utilization
of this source code in whole or in part is  prohibited without  written consent from
Aricent Technologies
 
           File Name                    : MailingSystem.java
           Principal Author             : Java_Th3_06
           Subsystem Name               : Training Project
           Module Name                  : Mailing System
           Date of First Release        :20/01/2016
           Author                       :  Java_Th3_06
           Description                  : To send mail for important information
 
 
           Change History
 
           Version                       : Initial Release
           Date(DD/MM/YYYY)              :14/02/2016
           Modified by                   :Java_TH3+06
           Description of change         : Initial Release
 
***********************************************************************/
package aricent.project.model.businesslogic;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *	Used for mailing important message
 *	@see MailingSystem
 *	@see MailingSystem#sendMailViaSSL
 *	@version text
 *	@author java_Th3_06
 *  @since  14/02/2016
 */

public class MailingSystem {
	private static String sender="anamika.insurance@gmail.com"; //set the mailing id
	private static String password="Whatpassword";//set the password
	 /**
	 *  Uses ssl for sending mail
	 *    @see MailingSystem
	 *	@version text
	 *	@author java_th3_06
	 *    @since 14/02/2014
	 */

	public int sendMailViaSSL(String receiver,String subject,String content)
	{
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465"); //set the properties

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(sender,password);
				}
			});//set the properties

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(MailingSystem.sender));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(receiver)); //initialize the message
			message.setSubject(subject);
			message.setText(content);

			Transport.send(message); //send the message

			System.out.println("Done");

		}//end try 
		catch (MessagingException e) {
			throw new RuntimeException(e);
		}//end catch
		return 1;
		
	}
	
	public int sendMailViaTLS(String receiver,String subject,String content)
	{
		final String username = "username@gmail.com";
		final String password = "password";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("from-email@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("to-email@gmail.com"));
			message.setSubject("Anamika Insurance Systems");
			message.setText("Dear User,"
				+ "\n\n No spam to my email, please!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		return 1;
	}

}
