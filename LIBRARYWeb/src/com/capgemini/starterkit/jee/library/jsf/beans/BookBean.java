package com.capgemini.starterkit.jee.library.jsf.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import com.capgemini.starterkit.jee.library.entities.BOOK;
import com.capgemini.starterkit.jee.library.service.BookService;
import java.io.Serializable;




@SessionScoped
@ManagedBean(name = "bookBean")
public class BookBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1493819788935830378L;
	@EJB
	BookService service;
	
	
	public List<BOOK> getBooks() {
		return service.findBOOKs();
	}
}
