package com.javatraining.advancejava.javamail;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMailExample {
	
	public static void main(String[] args) {
		final String userName = "<base64 email>";
		final String password = "<base64 password>";
		Decoder decoder  = Base64.getDecoder();
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
		
        Session session = Session.getDefaultInstance(prop,new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(new String(decoder.decode(userName)),new String(decoder.decode(password)));
			}
        	
		});
        
        try {
        	Message message = new MimeMessage(session);
        	 message.setFrom(new InternetAddress(new String(decoder.decode(userName))));
             message.setRecipients(
                     Message.RecipientType.TO,
                     InternetAddress.parse("<email1>,<email2>")
             );
             message.setSubject("Testing Gmail TLS");
             message.setText("Dear Mail Crawler,"
                     + "\n\n Please do not spam my email!");

             Transport.send(message);

             System.out.println("Done");
        }catch (MessagingException e) {
        	e.printStackTrace();
        }
        
        
	}

}
