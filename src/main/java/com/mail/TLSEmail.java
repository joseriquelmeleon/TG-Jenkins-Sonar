package com.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

public class TLSEmail {
	
	public static void sendEmail(String[] toEmail, String subject, String body){
		final String user = "jolutestgroup@gmail.com";
		final String password = "202202TG"; // correct password for gmail id
//		final String user = "";
//		final String password = ""; // correct password for gmail id
		
		System.out.println("TLSEmail Start");
		
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host - smtp.gmail.com
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); //Certificado SSL
		props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.ssl.protocols", "TLSv1.2");
	    props.put("mail.smtp.port", "465");
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
		
		//create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		EmailUtil.sendEmail(session, toEmail, subject, body);
	}
}