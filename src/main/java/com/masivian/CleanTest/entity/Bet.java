package com.masivian.CleanTest.entity;

import javax.persistence.*;

@Entity
@Table(name="bet")
public class Bet {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="id")
	private int id;
	
	@Column(name="number")
	private int number;
	
	@Column(name="color")
	private String color;
	
	@Column(name="value")
	private double value;
	
	@JoinColumn(name = "id_roulette", nullable = false)
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Roulette roulette;
	
	@JoinColumn(name = "id_user", nullable = false)
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private User user;

	public Bet() { }
			
	public Bet(int id, int number, String color, double value, Roulette roulette, User user) {
		this.id = id;
		this.number = number;
		this.color = color;
		this.value = value;
		this.roulette = roulette;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public Roulette getRoulette() {
		return roulette;
	}

	public void setRoulette(Roulette roulette) {
		this.roulette = roulette;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}	
}
