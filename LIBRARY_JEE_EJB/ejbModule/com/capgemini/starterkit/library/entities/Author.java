package com.capgemini.starterkit.library.entities;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "AUTHOR")
@PrimaryKeyJoinColumn(name = "author_id", referencedColumnName = "id")
public class AuthorEntity implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "AUTHOR_ID")
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