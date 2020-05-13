package com.Exam.config;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Indexing implements ApplicationRunner{
	
	@PersistenceContext EntityManager en;
	

	@Override
	@Transactional
	public void run(ApplicationArguments args) throws Exception {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(en);
		try {
			fullTextEntityManager.createIndexer().startAndWait();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
