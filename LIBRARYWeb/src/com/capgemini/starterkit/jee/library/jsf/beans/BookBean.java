package com.capgemini.starterkit.jee.library.jsf.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.capgemini.starterkit.jee.library.entities.AUTHOR;
import com.capgemini.starterkit.jee.library.entities.BOOK;
import com.capgemini.starterkit.jee.library.service.BookService;

import java.io.Serializable;




@ViewScoped
@ManagedBean(name = "bookBean")
public class BookBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1493819788935830378L;
	@EJB
	BookService service;
	
	List<BOOK> filteredBooks;
	
	List<BOOK> books;
	
	BOOK selectedBOOK;
	
	@PostConstruct
    public void init() {
        books = service.findBOOKs();
    }
	public List<BOOK> getBooks() {
		return books;
	}

	public void setBooks(List<BOOK> books) {
		this.books = books;
	}

	public List<BOOK> getFilteredBooks() {
		return filteredBooks;
	}

	public void setFilteredBooks(List<BOOK> filteredBooks) {
		this.filteredBooks = filteredBooks;
	}
	public BOOK getSelectedBOOK() {
		return selectedBOOK;
	}
	public void setSelectedBOOK(BOOK selectedBOOK) {
		this.selectedBOOK = selectedBOOK;
	}
	
	
	

}