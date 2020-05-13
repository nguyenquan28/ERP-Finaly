package com.Exam.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.Exam.dto.ProductRequest;

@Service
public class GenerateExcel implements GenerateFileService{
		
	
	@Override
	public ByteArrayOutputStream createFile(List<ProductRequest> list) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet =  workbook.createSheet();
		
		Row headerRow = sheet.createRow(0);
		
		headerRow.createCell(0).setCellValue(" ");
		headerRow.createCell(1).setCellValue(" ");
		headerRow.createCell(2).setCellValue("Bảng báo giá sản phẩm ");
		headerRow.createCell(3).setCellValue(" ");
		headerRow.createCell(4).setCellValue(" ");
		
		Row fieldRow = sheet.createRow(1);
		fieldRow.createCell(0).setCellValue("Mã sản phẩm");
		fieldRow.createCell(1).setCellValue("Tên sản phẩm");
		fieldRow.createCell(2).setCellValue("Đơn giá");
		fieldRow.createCell(3).setCellValue("Số lượng");
		fieldRow.createCell(4).setCellValue("Thành tiền");
		int j = 2;
		int total = 0;
		for (int i = 0; i < list.size(); i++) {
			Row dataRow = sheet.createRow(i+2);
			dataRow.createCell(0).setCellValue(list.get(i).getId());
			dataRow.createCell(1).setCellValue(list.get(i).getName());
			dataRow.createCell(2).setCellValue(list.get(i).getPrice());
			dataRow.createCell(3).setCellValue(list.get(i).getAmount());
			dataRow.createCell(4).setCellValue(list.get(i).getSum());
			total+=list.get(i).getSum();
			j++;
		}
		DecimalFormat df2 = new DecimalFormat( "#,###,###,##0.00" );
		Row sumRow = sheet.createRow(j);
		sumRow.createCell(3).setCellValue("Tổng tiền");
		sumRow.createCell(4).setCellValue(df2.format(total)+"vnđ");
		
		
		sheet.autoSizeColumn(0);
		sheet.autoSizeColumn(1);
		sheet.autoSizeColumn(2);
		sheet.autoSizeColumn(3);
		sheet.autoSizeColumn(4);
		
		
		
		
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		workbook.write(arrayOutputStream);
		workbook.close();
		arrayOutputStream.close();
		return arrayOutputStream;
		
	}
	
}
