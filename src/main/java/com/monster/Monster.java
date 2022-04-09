package com.monster;

import java.util.List;

import com.move.Move;
import com.monstersaku.Condition;
import com.monstersaku.Stats;

public class Monster {
    private int id;
    private String nama;
    private List<ElementType> elementTypes;
    private Stats baseStats;
    private List<Move> moves;
    private Condition condi;
    private final double maxHP;

    // Konstruktor
    public Monster(int id, String nama, List<ElementType> elementTypes, Stats baseStats, List<Move> moves){
        this.id = id;
        this.setNama(nama);
        this.setElementTypes(elementTypes);
        this.setBaseStats(baseStats);
        this.setMoves(moves);
        this.condi = new Condition();
        this.maxHP = baseStats.getHealthPoint();
    }


    // Getter
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public List<ElementType> getElementTypes() {
        return elementTypes;
    }

    public Stats getBaseStats() {
        return baseStats;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public Condition getCondi() {
        return condi;
    }

    public double getMaxHP() {
        return maxHP;
    }

    // Setter

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setElementTypes(List<ElementType> elementTypes) {
        this.elementTypes = elementTypes;
    }

    public void setBaseStats(Stats baseStats) {
        this.baseStats = baseStats;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setCondi(Condition condi) {
        this.condi = condi;
    }

    // print move
    public void printMoves() {
        for (int i = 0; i < moves.size(); i++) {
            System.out.printf("[%d] " + moves.get(i).getMoveName(), i+1);
        }
    }
}
