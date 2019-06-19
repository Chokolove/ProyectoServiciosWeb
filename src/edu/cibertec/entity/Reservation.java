package edu.cibertec.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="soccerFieldId")
	private SoccerField soccerField;
	private int reserverId;
	private String reserverType;
	private String date;
	private int start;
	private int end;
	private int chargeId;
	private String createdAt;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SoccerField getSoccerField() {
		return soccerField;
	}
	public void setSoccerField(SoccerField soccerField) {
		this.soccerField = soccerField;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	
}
