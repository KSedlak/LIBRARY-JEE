package com.capgemini.starterkit.jee.library.entities;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "AUTHOR")
public class AUTHOR implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	@javax.persistence.GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name = "FIRSTNAME")
    private String firstName;

	 @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	    @JoinTable(name = "BOOK_AUTHOR",
	            joinColumns = {@JoinColumn(name = "AUTHOR_ID", nullable = false, updatable = false)},
	            inverseJoinColumns = {@JoinColumn(name = "BOOK_ID", nullable = false, updatable = false)})
	    private Set<BOOK> books;
	
	@Column(name = "LASTNAME")
    private String lastName;

	
	public String getFirstName() {
		return firstName;
	}

	public AUTHOR(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		books=new HashSet<BOOK>();
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	

	public AUTHOR() {
		super();
		books=new HashSet<BOOK>();
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Set<BOOK> getBooks() {
		return books;
	}

	public void setBooks(Set<BOOK> books) {
		this.books = books;
	}
	public String getBookString() {
		String res = "";
		
		if(books.size()==0){
			return res;
		}
		for (BOOK b : books) {
			res = res + b.getTitle() + ", ";
		}

		return res.substring(0, res.length() - 2);
	}
}