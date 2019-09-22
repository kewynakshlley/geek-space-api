package com.ufpb.geekspace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailingService {
	@Autowired
	private JavaMailSender jms;
	
	public void send(String email, String subject, String message) {
		SimpleMailMessage emailMsg = new SimpleMailMessage();
		emailMsg.setTo(email);
		emailMsg.setSubject(subject);
		emailMsg.setText(message);
		jms.send(emailMsg);
	}

}
