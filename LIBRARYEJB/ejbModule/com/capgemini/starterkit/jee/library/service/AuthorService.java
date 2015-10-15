package com.capgemini.starterkit.jee.library.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.capgemini.starterkit.jee.library.entities.AUTHOR;


@Stateless
@LocalBean
public class AuthorService {

    public AuthorService() {

    }
    
    @PersistenceContext(unitName = "LIBRARY_PU")
	EntityManager em;

	public List<AUTHOR> findAUTHORs() {
		return em.createQuery("Select author From AUTHOR author", AUTHOR.class)
				.getResultList();
	}
	
	public AUTHOR addAuthor(AUTHOR a){
		em.persist(a);
		return a;
	}
	
	public AUTHOR removeAuthor(AUTHOR a){
		em.remove(a);
		return a;
	}
	
	public AUTHOR editAuthor(AUTHOR a){
		AUTHOR fromDB=em.find(AUTHOR.class, a.getId());
			fromDB.setFirstName(a.getFirstName());
			fromDB.setLastName(a.getLastName());
		em.persist(fromDB);
		return fromDB;
		
	}
	public List<AUTHOR> findByName(String name){
		@SuppressWarnings("unchecked")
		List<AUTHOR> resultList = em.createQuery("select author from AUTHOR author where upper(author.firstName) like concat(upper(:name), '%')")
				.setParameter("name", name).getResultList();
		return resultList;
	}
	
	public List<AUTHOR> findByLastName(String name){
		@SuppressWarnings("unchecked")
		List<AUTHOR> resultList = em.createQuery("select author from AUTHOR author where upper(author.lastName) like concat(upper(:name), '%')")
				.setParameter("name", name).getResultList();
		return resultList;
	}
	
	public List<AUTHOR> findByLastORFirstName(String name){
		@SuppressWarnings("unchecked")
		List<AUTHOR> resultList = em.createQuery("select author from AUTHOR author where upper(author.lastName) like concat(upper(:name) OR  upper(author.firstName) like concat(upper(:name), '%')")
				.setParameter("name", name).getResultList();
		return resultList;
	}

	
}
