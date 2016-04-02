package com.frugalbin.communication.sender;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.frugalbin.communication.exceptions.BusinessException;
import com.frugalbin.communication.models.CommunicationConnectionInfo;

public class EmailSender
{
	private static volatile EmailSender instance;

	public static EmailSender getInstance() throws BusinessException
	{
		if (instance == null)
		{
			synchronized (EmailSender.class)
			{
				if (instance == null)
				{
					throw new BusinessException(1001, "Instance for Email Sender hasn't been created yet");
				}
			}
		}

		return instance;
	}

	public static void createInstance(CommunicationConnectionInfo commConnInfo) throws BusinessException
	{
		if (instance == null)
		{
			synchronized (EmailSender.class)
			{
				if (instance == null)
				{
					instance = new EmailSender(commConnInfo);
				}
			}
		}

		throw new BusinessException(1001, "Instance has been already created");
	}

	private Session session;

	private EmailSender(CommunicationConnectionInfo commConnInfo)
	{
		String host = commConnInfo.getConnectionUrl();
		String port = commConnInfo.getPort();
		final String user = commConnInfo.getUserName();// change accordingly
		final String password = commConnInfo.getPassword();// change accordingly

		// Get the session object
		Properties props = new Properties();
		// props.put("mail.smtp.host", host);
		// props.put("mail.smtp.auth", "true");

		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);

		session = Session.getDefaultInstance(props, new javax.mail.Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication()
			{
				return new PasswordAuthentication(user, password);
			}
		});
	}

	public void sendEmail(String to, String from, String subject, String messageBody)
	{
		// Compose the message
		try
		{
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(subject);
			message.setText(messageBody);

			// send the message
			Transport.send(message);

			System.out.println("message sent successfully...");

		}
		catch (MessagingException e)
		{
			e.printStackTrace();
		}
	}
}
