package edu.cibertec.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="local")
public class Local {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="partnerId")
	private Partner partner;
	private String name;
	private String description;
	private String address;
	private double latitude;
	private double longitude;
	private int anticipation;
	@Column(name="created_at")
	private String createdAt;
	@Column(name="deleted_at")
	private String deletedAt;
	@OneToMany(mappedBy="local", cascade= CascadeType.PERSIST)
	private Collection<LocalWorkingWeekDay>localWorkingWeekDays=new ArrayList<LocalWorkingWeekDay>();
	@OneToMany(mappedBy="local", cascade= CascadeType.PERSIST)
	private Collection<LocalNonWorkingDay>localNonWorkingDays = new ArrayList<LocalNonWorkingDay>();
	@OneToMany(mappedBy="local", cascade= CascadeType.PERSIST)
	private Collection<SoccerField>soccerFields = new ArrayList<SoccerField>();
	
	public Collection<LocalWorkingWeekDay> getLocalWorkingWeekDays() {
		return localWorkingWeekDays;
	}
	public void setLocalWorkingWeekDays(Collection<LocalWorkingWeekDay> localWorkingWeekDays) {
		this.localWorkingWeekDays = localWorkingWeekDays;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
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
	public Collection<LocalNonWorkingDay> getLocalNonWorkingDays() {
		return localNonWorkingDays;
	}
	public void setLocalNonWorkingDays(Collection<LocalNonWorkingDay> localNonWorkingDays) {
		this.localNonWorkingDays = localNonWorkingDays;
	}
	public Collection<SoccerField> getSoccerFields() {
		return soccerFields;
	}
	public void setSoccerFields(Collection<SoccerField> soccerFields) {
		this.soccerFields = soccerFields;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(String deletedAt) {
		this.deletedAt = deletedAt;
	}
	
}
