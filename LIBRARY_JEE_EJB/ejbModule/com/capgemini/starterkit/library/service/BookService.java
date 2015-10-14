package com.capgemini.starterkit.library.service;

import java.util.List;
import javax.annotation.Resource;
import javax.annotation.security.PermitAll;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.capgemini.starterkit.library.entities.BookEntity;



/**
 * Session Bean implementation class TODOsManagementService
 */
@Stateless
@LocalBean
@PermitAll
public class TODOsManagementService {

	@PersistenceContext(unitName = "BookPU")
	EntityManager em;
	
	@Resource
	SessionContext sessionContext;


	public List<BookEntity> findBooks() {
		return em.createQuery("Select book From Book td Order By book.title", BookEntity.class)
				.getResultList();
	}



}
