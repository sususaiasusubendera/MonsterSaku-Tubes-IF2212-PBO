package com.game;

import java.util.*;

public class Player {
	private String name;
	private ArrayList<Monster> listOfMonster;

	// konstruktor
	public Player(String name, ArrayList<Monster> listOfMonster) {
		this.name = name;
		this.listOfMonster = listOfMonster;
	}

	// getter
	public String getName() {
		return this.name;
	}

	public ArrayList<Monster> getListOfMonster() {
		return this.listOfMonster;
	}

	public int getNumberOfMonster() {
		return this.listOfMonster.size();
	}

	// setter
	public void setName(String name) {
		this.name = name;
	}

	public void setListofMonster(ArrayList<Monster> listOfMonster) {
		this.listOfMonster = listOfMonster;
	}

}