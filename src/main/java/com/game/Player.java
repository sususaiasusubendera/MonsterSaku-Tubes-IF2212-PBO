package com.game;

import java.util.*;
import com.monster.*;
import com.monstersaku.*;

public class Player {
	private String name;
	private ArrayList<Monster> listOfMonster;
	private Monster currentMonster;

	/***
	 * 	1;Chairmander;FIRE,NORMAL;100,100,100,100,100,100;1,2
		2;Pikachu;NORMAL;100,100,100,100,100,100;3,2
		3;Thievul;NORMAL;70,58,58,87,92,90;2
		4;Buizel;WATER;55,65,35,60,30,85;4
		5;Drizzile;WATER,NORMAL;65,60,55,95,55,90;5,1
		6;Lombre;WATER,GRASS;60,50,50,60,70,50;1,3,2
		7;Bibarel;NORMAL,WATER;79,85,60,55,60,71;4,5
	 * 
	*/


	// konstruktor
	public Player(String name) {
		this.name = name;
		this.listOfMonster = new ArrayList<Monster>();
		List<Monster> monstercandidates = new ArrayList<Monster>(Reader.getGameMonsters()); // readernya kemungkinan error, soalnya listnya gk keisi

		for (int i = 0; i < 6; i++) {
			int randomMonster = new Random().nextInt(monstercandidates.size());
			Monster mons = monstercandidates.get(randomMonster);
			this.listOfMonster.add(mons);
			monstercandidates.remove(mons);
		}
		int rando = new Random().nextInt(listOfMonster.size());
		this.currentMonster = listOfMonster.get(rando);

		// untuk debugging
		System.out.println("/***");
		System.out.printf("Monsternya %s:\n", getName());
		printMonsters();
		System.out.println("***/");
		System.out.println("");
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
}