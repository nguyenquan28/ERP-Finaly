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

import com.Exam.DAO.SearchOrderDAO;
import com.Exam.Entity.Orders;

@Repository
public class SearchOrderDAOIml implements SearchOrderDAO {

	@PersistenceContext 
	EntityManager en;
	
	@Override
	@Transactional
	public List<Orders> search(String q,int pageNumber) {
		FullTextQuery fullTextQuery = querySearch(q);
		System.out.println(fullTextQuery.getResultSize());
		fullTextQuery.setFirstResult(pageNumber);		
		fullTextQuery.setMaxResults(5);		
		List<Orders>list = fullTextQuery.getResultList();				
		return list;
	}
	
	public FullTextQuery querySearch(String q) {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(en);
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Orders.class).get();
		Query luceneQuery = queryBuilder.keyword().onFields("id","tenKH","email").matching(q.toLowerCase()).createQuery();
		FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Orders.class);
		return fullTextQuery;
	}
	
	public FullTextQuery getQuerySearch(String q) {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(en);
		QueryBuilder queryBuilder = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Orders.class).get();
		Query luceneQuery = queryBuilder.keyword().onFields("id","tenKH","email","trangThai").matching(q.toLowerCase()+" chưa").createQuery();
		FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Orders.class);
		return fullTextQuery;
	}

	@Override
	public int searchResultCount(String q) {
		FullTextQuery fullTextQuery = querySearch(q);
		int resultCount = fullTextQuery.getResultSize();
		return resultCount;
	}

	@Override
	public List<Orders> timKhachHangChuaThanhToan(String q) {
		FullTextQuery fullTextQuery = getQuerySearch(q);		
		fullTextQuery.setMaxResults(1);
		List<Orders>list = fullTextQuery.getResultList();
		
		
		return list;
	}

}
