package edu.cibertec.dto;

import java.util.List;

public class LocalAdvDTO {
	
	private int id;
	private String nombre;
	private String description;
	private String address;
	private String latitude;
	private String longitude;
	private List<LocWorDayDTO> listWorDays;
	private List<LocNonDaysDTO> listNonDays;
	private List<SoccerFieldDTO> listSocField;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public List<LocWorDayDTO> getListWorDays() {
		return listWorDays;
	}
	public void setListWorDays(List<LocWorDayDTO> listWorDays) {
		this.listWorDays = listWorDays;
	}
	public List<LocNonDaysDTO> getListNonDays() {
		return listNonDays;
	}
	public void setListNonDays(List<LocNonDaysDTO> listNonDays) {
		this.listNonDays = listNonDays;
	}
	public List<SoccerFieldDTO> getListSocField() {
		return listSocField;
	}
	public void setListSocField(List<SoccerFieldDTO> listSocField) {
		this.listSocField = listSocField;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
