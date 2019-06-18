package edu.cibertec.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="account")
public class Account  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String password;
	private String confirmedAt;
	private String lockedAt;
	private String lastLogin;
	@OneToMany(mappedBy="account", cascade= CascadeType.PERSIST)
	private Collection<Partner> parteners = new ArrayList<Partner>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
