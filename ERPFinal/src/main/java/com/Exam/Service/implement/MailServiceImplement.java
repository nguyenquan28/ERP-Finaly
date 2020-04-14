package com.Exam.service.implement;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.activation.DataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.Exam.ErpFinalApplication;
import com.Exam.Entity.Customer;
import com.Exam.Entity.Product;
import com.Exam.dto.EmailRequest;
import com.Exam.dto.ProductRequest;
import com.Exam.service.GenerateExcel;
import com.Exam.service.GenerateFileService;
import com.Exam.service.MailService;
import com.sun.mail.iap.ByteArray;
@Service
public class MailServiceImplement implements MailService {

	@Autowired
	TemplateEngine template;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired 
	private GenerateFileService file;
	@Override
	public void send(String from, String to, String subject, String htmlPage,Context context,List<ProductRequest>list) throws IOException {
		String htmlContent = template.process(htmlPage, context);
		
		ByteArrayOutputStream arrayOutputStream = this.file.createFile(list);
		InputStreamSource inputStreamSource = new ByteArrayResource(arrayOutputStream.toByteArray());
		
		try {
			
			MimeMessage mimeMessage = this.mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "utf-8");
			helper.setFrom(from);
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(htmlContent, true);
			helper.addAttachment("bangbaogia.xlsx", inputStreamSource);
			
				
				
			this.mailSender.send(mimeMessage);
			System.out.println("Thành công");
		} catch (Exception e) {
			e.printStackTrace();
		}								
	}

	@Override
	public void sendMailHelp(List<ProductRequest> products, List<EmailRequest> customers) throws IOException {
		Context context = new Context();
		
		int sum = products.stream().mapToInt(i-> i.getSum()).sum();
//		
		context.setVariable("sum", sum);
		context.setVariable("products", products);
		
		
		
		
			
		
		
		customers.stream().forEach(i->{
			
			context.setVariable("customerName", i.getName());			
			try {
				send("nguyenhoangvu12c5@gmail.com",i.getEmail()	,"Bảng Báo giá sản phẩm", "mail", context,products);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		
	}
	
	

}
