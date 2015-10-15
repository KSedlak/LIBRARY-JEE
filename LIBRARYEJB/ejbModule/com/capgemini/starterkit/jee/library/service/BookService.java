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

	@PersistenceContext(unitName = "LIBRARY_PU")
	EntityManager em;

	public List<BOOK> findBOOKs() {
		return em.createQuery("Select book From BOOK book", BOOK.class)
				.getResultList();
	}

	public BOOK addBOOK(BOOK b) {
		em.persist(b);
		return b;
	}

	public BOOK removeBOOK(BOOK b) {
		em.remove(b);
		return b;
	}

	public BOOK editBOOK(BOOK b) {
		BOOK fromDB = em.find(BOOK.class, b.getId());
		fromDB.setTitle(b.getTitle());
		em.persist(fromDB);
		return fromDB;

	}

	public List<BOOK> findByTitle(String title) {
		@SuppressWarnings("unchecked")
		List<BOOK> resultList = em
				.createQuery(
						"select book from BOOK book where upper(book.title) like concat(upper(:title), '%')")
				.setParameter("title", title).getResultList();
		return resultList;
	}

}
