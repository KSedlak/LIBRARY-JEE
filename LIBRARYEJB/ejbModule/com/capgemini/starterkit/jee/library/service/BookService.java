package com.capgemini.starterkit.jee.library.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.capgemini.starterkit.jee.library.entities.BOOK;

/**
 * Session Bean implementation class BookService
 */
@Stateless
@LocalBean
public class BookService {

    public BookService() {

    }
    
    @PersistenceContext(unitName = "BooksPU")
	EntityManager em;

	public List<BOOK> findBOOKs() {
		return em.createQuery("Select book From BOOK book", BOOK.class)
				.getResultList();
	}

}
