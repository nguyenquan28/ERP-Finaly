<<<<<<< HEAD:ERPFinal/src/main/java/com/Exam/Service/ProductServcie.java
package com.Exam.service;
=======
package com.Exam.service.implement;
>>>>>>> 9871b449c1a0415fd0680337103379966462a6cf:ERPFinal/src/main/java/com/Exam/service/implement/ProductServiceImplement.java

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import com.Exam.DAO.ProductDAO;
import com.Exam.Entity.Product;
import com.Exam.service.ProductServcie;

<<<<<<< HEAD:ERPFinal/src/main/java/com/Exam/Service/ProductServcie.java

public interface ProductServcie {
	
	//lay tat ca du lieu cua san pham
	public List<Product> getAllProduct();
=======
@Service
public class ProductServiceImplement implements ProductServcie{
	@Autowired
	ProductDAO productDAO;
	
	//lay tat ca du lieu cua san pham
	@Cacheable("products")
	public List<Product> getAllProduct(){
		return productDAO.findAll();
	}
>>>>>>> 9871b449c1a0415fd0680337103379966462a6cf:ERPFinal/src/main/java/com/Exam/service/implement/ProductServiceImplement.java
	//tim kiem trong kho theo ten
	public List<Product> SelectByName(String nameSP);
	
//	Get one Product by ID
	public Optional<Product> getProductById(int maSP);
	
//	Save Product in Carts
	public void insertOneProduct(Product product) ;
	
	
		
		
	
}
