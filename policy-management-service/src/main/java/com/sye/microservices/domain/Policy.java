package com.sye.microservices.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Policy {

	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private boolean done;
	private Date premiumDate;
	private Double premiumAmount;
	private String username;
	
	
	
	public Policy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Policy(Long id, String description, boolean done, Date premiumDate, Double premiumAmount,String username) {
		super();
		this.id = id;
		this.description = description;
		this.done = done;
		this.premiumDate = premiumDate;
		this.premiumAmount = premiumAmount;
		this.username=username;
	}
	
	public Policy(String description, boolean done, Date premiumDate, Double premiumAmount,String username) {
		super();
		//this.id = id;
		this.description = description;
		this.done = done;
		this.premiumDate = premiumDate;
		this.premiumAmount = premiumAmount;
		this.username=username;
	}

	@Override
	public String toString() {
		return "Policy [id=" + id + ", description=" + description + ", done=" + done + ", premiumDate=" + premiumDate
				+ ", premiumAmount=" + premiumAmount + ", username=" + username + "]";
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public Date getPremiumDate() {
		return premiumDate;
	}

	public void setPremiumDate(Date premiumDate) {
		this.premiumDate = premiumDate;
	}

	public Double getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Double premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	
	
	
}
