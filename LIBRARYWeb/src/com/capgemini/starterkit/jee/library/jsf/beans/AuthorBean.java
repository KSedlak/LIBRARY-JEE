package com.capgemini.starterkit.jee.library.jsf.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.hibernate.validator.internal.util.privilegedactions.NewSchema;

import com.capgemini.starterkit.jee.library.entities.AUTHOR;
import com.capgemini.starterkit.jee.library.service.AuthorService;





import java.io.Serializable;




@ViewScoped
@ManagedBean(name = "authorBean")
public class AuthorBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1493819788935830378L;
	@EJB
	AuthorService service;
	
	List<AUTHOR> filteredAuthors;
	
	List<AUTHOR> authors;
	
	AUTHOR selectedAuthor;
	
	@PostConstruct
    public void init() {
        authors = service.findAUTHORs();
    }

	public List<AUTHOR> getFilteredAuthors() {
		return filteredAuthors;
	}

	public void setFilteredAuthors(List<AUTHOR> filteredAuthors) {
		this.filteredAuthors = filteredAuthors;
	}

	public List<AUTHOR> getAuthors() {
		return authors;
	}

	public void setAuthors(List<AUTHOR> authors) {
		this.authors = authors;
	}

	public AUTHOR getSelectedAuthor() {
		return selectedAuthor;
	}

	public void setSelectedAuthor(AUTHOR selectedAuthor) {
		this.selectedAuthor = selectedAuthor;
	}
	
	
	public void createNewAuthor(){
		selectedAuthor=new AUTHOR();
	}
	
	public void saveEditedAuthor(){
		FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Saved " + selectedAuthor.getFirstName() + " " + selectedAuthor.getLastName()));
		service.editAuthor(selectedAuthor);
		selectedAuthor=new AUTHOR();
	}
	
	
	
	

}