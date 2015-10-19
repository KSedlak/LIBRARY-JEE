package com.capgemini.starterkit.jee.library.jsf.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
        filteredBooks=service.findBOOKs();
        selectedBOOK=new BOOK();
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

	public void createNewBook(){
		selectedBOOK=new BOOK();
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
	
	public void saveEditeBOOK(){
		FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Pomyslnie zapisano " +selectedBOOK.getTitle()));
		service.editBOOK(selectedBOOK);
		selectedBOOK=new BOOK();
	}
	
	public void removeSelectedBook(BOOK book){
		books.remove(book);
		filteredBooks.remove(book);
		service.removeBOOK(book);
		
	}
	
	public void reload(){
		books.clear();
		filteredBooks.clear();
		books.addAll(service.findBOOKs());
		filteredBooks.addAll(service.findBOOKs());
	}
	
	
	
	public void saveNewBook(){
		FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Saved " +selectedBOOK.getTitle()));
		service.addBOOK(selectedBOOK);
		books.add(selectedBOOK);
		filteredBooks.add(selectedBOOK);
		selectedBOOK=new BOOK();
	}

}