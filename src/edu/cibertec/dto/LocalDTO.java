package edu.cibertec.dto;

import java.io.Serializable;


import edu.cibertec.entity.Partner;

public class LocalDTO implements Serializable{
	
	private int id;
	private String name;
	private String description;
	private String address;
	private double latitude;
	private double longitude;
	private int anticipation;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public int getAnticipation() {
		return anticipation;
	}
	public void setAnticipation(int anticipation) {
		this.anticipation = anticipation;
	}
	
	
}
