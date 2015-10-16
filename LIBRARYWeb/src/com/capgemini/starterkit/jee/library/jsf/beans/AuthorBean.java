package com.capgemini.starterkit.jee.library.jsf.beans;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import com.capgemini.starterkit.jee.library.entities.AUTHOR;

import com.capgemini.starterkit.jee.library.service.AuthorService;

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
	
	private AUTHOR seletedAuthor;

	public List<AUTHOR> getAuthors() {
		return service.findAUTHORs();
	}

	public AUTHOR getSeletedAuthor() {
		return seletedAuthor;
	}

	public void setSeletedAuthor(AUTHOR seletedAuthor) {
		this.seletedAuthor = seletedAuthor;
	}




}
