package com.game;

import java.util.*;
import com.monster.*;
import com.monstersaku.*;

public class Player {
	private String name;
	private ArrayList<Monster> listOfMonster;
	private Monster currentMonster;

	// konstruktor
	public Player(String name) {
		this.name = name;
		this.listOfMonster = new ArrayList<Monster>();
		for (int i = 0; i < 6; i++) {
			int randomMonster = new Random().nextInt(Reader.getGameMonsters().size());
			Monster mons = Reader.getGameMonsters().get(randomMonster);
			this.listOfMonster.add(mons);
		}
		int rando = new Random().nextInt(listOfMonster.size());
		this.currentMonster = listOfMonster.get(rando);
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

	public Monster getCurrentMonster() {
		return this.currentMonster;
	}

	// setter
	public void setName(String name) {
		this.name = name;
	}

	public void setListofMonster(ArrayList<Monster> listOfMonster) {
		this.listOfMonster = listOfMonster;
	}

	public void setCurrentMonster(Monster currentMonster) {
		this.currentMonster = currentMonster;
	}

	public boolean isAllDead() {
		/***
		int sumHP = 0;
		for (Monster m : listOfMonster) {
			sumHP += m.getBaseStats().getHealthPoint();
		}
		if (sumHP == 0) {
			return true;
		} else {
			return false;
		}
		***/
		return listOfMonster.isEmpty();
	}

	public void printMonsters() {
		for (int i = 0; i < listOfMonster.size(); i++) {
            System.out.printf("[%d] " + listOfMonster.get(i).getNama(),"\n", i+1);
        }
	}
}