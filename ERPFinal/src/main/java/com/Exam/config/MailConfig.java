package com.Exam.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MailConfig implements WebMvcConfigurer {
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/bootstrap/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/bootstrap/4.0.0/");
    registry.addResourceHandler("/resources/jquery/**")
        .addResourceLocations("classpath:/META-INF/resources/webjars/jquery/3.0.0/");
    registry.addResourceHandler("/resources/css/**").addResourceLocations("classpath:/static/css/");
	}
	
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	     
	    mailSender.setUsername("nguyenhoangvu12c5@gmail.com");
	    mailSender.setPassword("hoangvune");
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	  
	     
	    return mailSender;  
	}
}
