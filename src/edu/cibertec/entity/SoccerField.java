package edu.cibertec.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SoccerField")
public class SoccerField {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="localId")
	private Local local;
	private String description;
	private double price;
	private String createdAt;
	private String deletedAt;
	@OneToMany(mappedBy="soccerField", cascade= CascadeType.PERSIST)
	private Collection<SoccerFieldPhoto>soccerFieldPhotos = new ArrayList<SoccerFieldPhoto>();
	@OneToMany(mappedBy="soccerField", cascade= CascadeType.PERSIST)
	private Collection<SoccerFieldMaintenance>soccerFieldMaintenances = new ArrayList<SoccerFieldMaintenance>();
	@OneToMany(mappedBy="soccerField", cascade= CascadeType.PERSIST)
	private Collection<Reservation>reservations = new ArrayList<Reservation>();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Local getLocal() {
		return local;
	}
	public void setLocal(Local local) {
		this.local = local;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
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
