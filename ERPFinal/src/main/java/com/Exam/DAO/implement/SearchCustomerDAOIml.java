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

import com.Exam.DAO.SearchCustomerDAO;
import com.Exam.Entity.Customer;

@Repository
public class SearchCustomerDAOIml implements SearchCustomerDAO{
	
	@PersistenceContext EntityManager en;
	
	@Override
	@Transactional
	public List<Customer> search(String q) {
		FullTextQuery fullTextQuery =  getFullTextQuery(q);
		List<Customer> list = fullTextQuery.getResultList();
		return list;
	}
	
	public FullTextQuery getFullTextQuery(String q) {
		
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(en);
		QueryBuilder queryBuilder =  fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Customer.class).get();
		Query query = queryBuilder.keyword().onFields("maKH","tenKH","email").matching(q.toLowerCase()).createQuery();
		
		FullTextQuery fullTextQuery =  fullTextEntityManager.createFullTextQuery(query, Customer.class);
		
		return fullTextQuery;
	}

}
