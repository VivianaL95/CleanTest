package com.masivian.CleanTest.entity;

import javax.persistence.*;

@Entity
@Table(name="roulette")
public class Roulette {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY )
	@Column(name="id")
	private int id;
	
	@Column(name="state")
	private boolean state;

	public Roulette() {	}
	
	public Roulette(int id, boolean state) {
		this.id = id;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
}
