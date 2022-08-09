package com.mail;

import java.util.Date;
import javax.mail.Message;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EmailUtil {

	/**
	 * Utility method to send simple HTML email
	 * @param session
	 * @param toEmail
	 * @param subject
	 * @param body
	 */
	public static void sendEmail(Session session, String[] toEmail, String subject, String body){
		try {
			Message msg = new MimeMessage(session);
			
			//set message headers
//			msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
			msg.setHeader("Content-type", "text/plain; charset=\"UTF-8\"");
//			msg.addHeader("format", "flowed");
//			msg.addHeader("Content-Transfer-Encoding", "8bit");

			
			msg.setFrom(new InternetAddress("jolutestgroup@gmail.com", "Mensaje de deteccion automatizado"));
			
			msg.setReplyTo(InternetAddress.parse("no_reply@example.com", false));
			
			msg.setSubject(subject);
			
//			msg.setSubject(subject, "UTF-8");
//			
//			msg.setText(body, "UTF-8");
			msg.setContent(body, "text/html");
			
			msg.setSentDate(new Date());	
			
			InternetAddress[] iCorreos = new InternetAddress [toEmail.length] ;
			
			for(int i=0;i<toEmail.length;i++){
				iCorreos[i] = new InternetAddress(toEmail[i]);
			}
			
			msg.setRecipients(Message.RecipientType.TO, iCorreos);
			
			System.out.println("El mensaje para enviar esta listo.");
			Transport.send(msg);  
			
			System.out.println("El correo se ha enviado exitosamente.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}