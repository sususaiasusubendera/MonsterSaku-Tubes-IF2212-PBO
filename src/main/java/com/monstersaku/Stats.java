package com.monstersaku;

public class Stats {
	private double healthPoint;
	private double attack;
	private double defense;
	private double specialAttack;
	private double specialDefense;
	private double speed;

	// konstruktor
	public Stats(double healthPoint, double attack, double defense, double specialAttack, double specialDefense, double speed) {
		this.healthPoint = healthPoint;
		this.attack = attack;
		this.defense = defense;
		this.specialAttack = specialAttack;
		this.specialDefense = specialDefense;
		this.speed = speed;
	}

	// getter
	public double getHealthPoint() {
		return this.healthPoint;
	}

	public double getAttack() {
		return this.attack;
	}

	public double getDefense() {
		return this.defense;
	}

	public double getSpecialAttack() {
		return this.specialAttack;
	}

	public double getSpecialDefense() {
		return this.specialDefense;
	}

	public double getSpeed() {
		return this.speed;
	}

	// setter
	public void setHealthPoint(double val) {
		this.healthPoint = val;
	}

	public void setAttack(double val) {
		this.attack = val;
	}

	public void setDefense(double val) {
		this.defense = val;
	}

	public void setSpecialAttack(double val) {
		this.specialAttack = val;
	}

	public void setSpecialDefense(double val) {
		this.specialDefense = val;
	}

	public void setSpeed(double val) {
		this.speed = val;
	}
}