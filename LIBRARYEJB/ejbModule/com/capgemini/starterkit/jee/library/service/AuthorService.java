package com.capgemini.starterkit.jee.library.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.capgemini.starterkit.jee.library.entities.BOOK;

@Stateless
@LocalBean
public class AuthorService {

    public AuthorService() {

    }
    
    @PersistenceContext(unitName = "LIBRARY_PU")
	EntityManager em;

	public List<BOOK> findAUTHORs() {
		return em.createQuery("Select author From AUTHOR author", BOOK.class)
				.getResultList();
	}

}
