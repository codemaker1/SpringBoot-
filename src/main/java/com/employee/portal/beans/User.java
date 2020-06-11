package com.employee.portal.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class User {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //@NotBlank(message = "Name is mandatory")
    private String firstName;
    
    private String lastName;
    
    @NotBlank(message = "Email is mandatory")
    private String emailAddress;


    private String password;
    
	public User() {
		super();
	}

	
	public User(String firstName, String lastName, @NotBlank(message = "Email is mandatory") String emailAddress,
			String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.password = password;
	}



	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


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


	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
    
    
}