package com.capgemini.starterkit.jee.library.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

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

	@Column(name = "LASTNAME")
    private String lastName;

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	

	public AUTHOR() {
		super();
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

}