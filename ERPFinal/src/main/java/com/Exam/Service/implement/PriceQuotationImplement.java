package com.Exam.Service.implement;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.Exam.Service.PriceQuotationService;

@Service
public class PriceQuotationImplement implements PriceQuotationService{
	
	@Autowired
	JavaMailSender mailSender;
	
	@Override
	public void send(String from, String to, String subject, String html) {
		
		try {
			MimeMessage message = this.mailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,true);
			messageHelper.setFrom(from);
			messageHelper.setTo(to);
			messageHelper.setSubject(subject);
			messageHelper.setText(html, true);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
