package com.Exam.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.Exam.dto.ProductRequest;

public interface GenerateFileService {
	
	public ByteArrayOutputStream createFile(List<ProductRequest>list)throws IOException;
}
