package com.Exam.DAO.implement;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.FullTextQuery;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import com.Exam.DAO.ProductDAO;
import com.Exam.DAO.SearchOrderDAO;
import com.Exam.DAO.SearchProductDAO;
import com.Exam.Entity.Product;

@Repository
public class SearchProductDAOImplement implements SearchProductDAO{

	@PersistenceContext EntityManager en;
	
	@Override
	@Transactional
	public List<Product> search(String q) {
		FullTextQuery fullTextQuery = getFullTextQuery(q);
		List<Product>products = fullTextQuery.getResultList();
		
		return products;
	}
	
	
	public FullTextQuery getFullTextQuery (String q) {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(en);
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Product.class).get();
		Query query = queryBuilder.keyword().onFields("maSP","tenSP").matching(q.toLowerCase()).createQuery();
		FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(query, Product.class);
		return fullTextQuery;
		
	}

}
