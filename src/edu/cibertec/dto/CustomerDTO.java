package edu.cibertec.dto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.cibertec.entity.Account;

public class CustomerDTO {
	
	private int id;
	private AccountDTO account;
	private String firstName;
	private String lastName;
	private String birthday;
	private int phone;
	private String email;
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
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
