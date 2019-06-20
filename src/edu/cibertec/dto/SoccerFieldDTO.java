package edu.cibertec.dto;

import java.util.List;

public class SoccerFieldDTO {
	private int id;
	private String description;
	private List<ReservedDTO>reservedDTOs;
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
	public List<ReservedDTO> getReservedDTOs() {
		return reservedDTOs;
	}
	public void setReservedDTOs(List<ReservedDTO> reservedDTOs) {
		this.reservedDTOs = reservedDTOs;
	}
	
}
