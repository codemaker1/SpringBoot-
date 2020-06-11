package com.employee.portal.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	public String description;
	
	public String department;
	
	public String emailAddress;

	public Ticket() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Ticket(String description, String department, String emailAddress) {
		super();
		this.description = description;
		this.department = department;
		this.emailAddress = emailAddress;
	}
	


	@Override
	public String toString() {
		return "Ticket [id=" + id + ", description=" + description + ", department=" + department + ", emailAddress="
				+ emailAddress + "]";
	}



	
	

}
