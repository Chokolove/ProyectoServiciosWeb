package edu.cibertec.dto;

import java.io.Serializable;

public class AccountDTO implements Serializable{

	private int id;
	private String confirmedAt;
	private String lockedAt;
	private String lastLogin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConfirmedAt() {
		return confirmedAt;
	}
	public void setConfirmedAt(String confirmedAt) {
		this.confirmedAt = confirmedAt;
	}
	public String getLockedAt() {
		return lockedAt;
	}
	public void setLockedAt(String lockedAt) {
		this.lockedAt = lockedAt;
	}
	public String getLastLogin() {
		return lastLogin;
	}
	public void setLastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}
	
}
