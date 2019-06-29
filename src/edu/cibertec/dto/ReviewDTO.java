package edu.cibertec.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.cibertec.entity.Customer;
import edu.cibertec.entity.Local;

public class ReviewDTO {
	
	private int id;
	private CustomerDTO customer;
	private String stars;
	private String commentary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public String getStars() {
		return stars;
	}
	public void setStars(String stars) {
		this.stars = stars;
	}
	public String getCommentary() {
		return commentary;
	}
	public void setCommentary(String commentary) {
		this.commentary = commentary;
	}
	
	
}
