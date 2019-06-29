package edu.cibertec.dto;

import edu.cibertec.entity.SoccerField;

public class ReservedAdvDTO {
	private String day;
	private int start;
	private int end;
	private SoccerFieldDTO soccerFieldDTO;
	private int chargeId;
	private double chargeAmount;
	private String createdAt;
	
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getEnd() {
		return end;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public SoccerFieldDTO getSoccerFieldDTO() {
		return soccerFieldDTO;
	}
	public void setSoccerFieldDTO(SoccerFieldDTO soccerFieldDTO) {
		this.soccerFieldDTO = soccerFieldDTO;
	}
	public int getChargeId() {
		return chargeId;
	}
	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}
	public double getChargeAmount() {
		return chargeAmount;
	}
	public void setChargeAmount(double chargeAmount) {
		this.chargeAmount = chargeAmount;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
}
