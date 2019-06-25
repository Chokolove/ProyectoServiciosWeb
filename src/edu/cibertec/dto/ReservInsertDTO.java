package edu.cibertec.dto;

public class ReservInsertDTO {
	private int soccerFieldId;
	private int reserverId;
	private String reserverType;
	private String day;
	private int start;
	private int end;
	private int chargeId;
	private String createDate;
	public int getSoccerFieldId() {
		return soccerFieldId;
	}
	public void setSoccerFieldId(int soccerFieldId) {
		this.soccerFieldId = soccerFieldId;
	}
	public int getReserverId() {
		return reserverId;
	}
	public void setReserverId(int reserverId) {
		this.reserverId = reserverId;
	}
	public String getReserverType() {
		return reserverType;
	}
	public void setReserverType(String reserverType) {
		this.reserverType = reserverType;
	}
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
	public int getChargeId() {
		return chargeId;
	}
	public void setChargeId(int chargeId) {
		this.chargeId = chargeId;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	
}
