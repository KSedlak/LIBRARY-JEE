package com.capgemini.starterkit.jee.library.jsf.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import com.capgemini.starterkit.jee.library.entities.AUTHOR;
import com.capgemini.starterkit.jee.library.entities.BOOK;
import com.capgemini.starterkit.jee.library.service.AuthorService;
import com.capgemini.starterkit.jee.library.service.BookService;

import java.io.Serializable;




@SessionScoped
@ManagedBean(name = "authorBean")
public class AuthorBean implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1549445104379752961L;
	@EJB
	AuthorService service;
	
	
	public List<AUTHOR> getAuthors() {
		return service.findAUTHORs();
	}
}
