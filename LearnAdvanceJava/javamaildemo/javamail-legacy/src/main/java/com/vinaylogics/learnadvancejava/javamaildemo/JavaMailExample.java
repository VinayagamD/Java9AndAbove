package com.vinaylogics.learnadvancejava.javamaildemo;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Base64;
import java.util.Properties;

public class JavaMailExample {

    public static void main(String[] args) {
        final String userName = "dmluYXlhZ2FtLm1lZXR1cEBnbWFpbC5jb20=";
        final String password = "RHJhZ29zQDE=";
        Base64.Decoder decoder  = Base64.getDecoder();
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.starttls.required", "true");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");

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
                    InternetAddress.parse("barathwaj.maadhavan@gmail.com")

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
