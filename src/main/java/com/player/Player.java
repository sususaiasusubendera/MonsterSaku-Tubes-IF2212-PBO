package com.player;

import java.util.*;

import com.monster.*;
import com.reader.Reader;

public class Player {
	private String name;
	private ArrayList<Monster> listOfMonster;
	private Monster currentMonster;

	// konstruktor
	public Player(String name) {
		this.name = name;
		this.listOfMonster = new ArrayList<Monster>();
		List<Monster> monstercandidates = new ArrayList<Monster>();
		for (Monster gameMonster : Reader.getGameMonsters()){
			Monster playerMonster = new Monster(gameMonster);
			monstercandidates.add(playerMonster);
		}
		for (int i = 0; i < 6; i++) {
			int randomMonster = new Random().nextInt(monstercandidates.size());
			Monster mons = monstercandidates.get(randomMonster);
			this.listOfMonster.add(mons);
			monstercandidates.remove(mons);
		}
		int rando = new Random().nextInt(listOfMonster.size());
		this.currentMonster = listOfMonster.get(rando);

		System.out.printf("Monsternya %s: \n", getName());
		List<String> monstersName = new ArrayList<String>();
		for (Monster m : listOfMonster) {
			monstersName.add(m.getNama());
		}
		System.out.printf("%s\n", monstersName.toString());
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
            // System.out.printf("[%d] " + listOfMonster.get(i).getNama(),"\n", i+1);
			System.out.printf("[%d] %s, HP: %.2f\n", i+1, listOfMonster.get(i).getNama(), listOfMonster.get(i).getBaseStats().getHealthPoint());
        }
	}

	// ngecekin kalo semua monsternya kena sleep
	public boolean isAllSleep() {
		// cek dulu monster lain ada yg gapunya sleep kah
		int nom = getNumberOfMonster();
		int sleepmonster = 0;
		for (Monster m : this.getListOfMonster()) {
            if (m.getCondi().getSleepCount() > 0) {
				sleepmonster += 1;
			}
		}
		if (nom == sleepmonster) {
			return true;
		} else {
			return false;
		}
	}

	// jika monsternya player mati
	public void removeCurrMonster(){
		System.out.println("Yah, monster milik "+ this.getName() + ", yaitu " + this.getCurrentMonster().getNama() + ", mati :(");
		// hapus monster dari list
		ArrayList<Monster> monsters = this.getListOfMonster();
		monsters.remove(this.getCurrentMonster());
		this.setListofMonster(monsters);
		// jika target masih punya monster
		if (!this.isAllDead()){
			System.out.println("Yuk ganti monster");
			com.game.SelectionMenu.chooseMonster(this);
		} else {
			Monster m = null;
			this.setCurrentMonster(m);
		}
	}
}