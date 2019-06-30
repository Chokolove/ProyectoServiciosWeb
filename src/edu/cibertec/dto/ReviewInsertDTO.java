package edu.cibertec.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.cibertec.entity.Customer;
import edu.cibertec.entity.Local;

public class ReviewInsertDTO {
	
	private int id;
	private int customerId;
	private int localId;
	private String stars;
	private String commentary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
	public int getLocalId() {
		return localId;
	}
	public void setLocalId(int localId) {
		this.localId = localId;
	}
	
	
	
}
