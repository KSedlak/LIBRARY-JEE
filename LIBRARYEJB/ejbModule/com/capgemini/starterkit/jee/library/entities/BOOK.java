package com.capgemini.starterkit.jee.library.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class BOOK {

	@Id
	@Column(name = "ID")
	@javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;

	 @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(name = "BOOK_AUTHOR",
	            joinColumns = {@JoinColumn(name = "BOOK_ID", nullable = false, updatable = false)},
	            inverseJoinColumns = {@JoinColumn(name = "AUTHOR_ID", nullable = false, updatable = false)})
	    private Set<AUTHOR> authors;

	
	@Column(name = "TITLE")
	String title;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<AUTHOR> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<AUTHOR> authors) {
		this.authors = authors;
	}
	
	public String getAuthorsString() {
		String res = "";
		for (AUTHOR a : authors) {
			res = res + a.getFirstName() + " " + a.getLastName() + ", ";
		}
		return res.substring(0, res.length() - 2);
	}
	
	
}