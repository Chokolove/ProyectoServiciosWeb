package edu.cibertec.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.cibertec.entity.Account;

public class PartnerDTO {
	private int id;
	private AccountDTO account;
	private String firstName;
	private String lastName;
	private String createdAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public AccountDTO getAccount() {
		return account;
	}
	public void setAccount(AccountDTO account) {
		this.account = account;
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
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
}
