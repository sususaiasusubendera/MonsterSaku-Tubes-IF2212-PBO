package com.move;

import com.monster.ElementType;
import com.monster.Monster;

public class Move {

    protected String moveType;
    protected String moveName;
    protected ElementType elementType;
    protected double accuracy;
    protected int priority;
    protected int ammunition;
    protected TargetOfMove targetOfMove;
    protected double effect;


    // Konstruktor Kelas Move
    // id berisi bilangan bulat positif unik

    public Move(String moveName, String moveType, ElementType elementType,double accuracy,
                int priority, int ammunition, TargetOfMove targetOfMove) {

        this.moveName = moveName;
        this.moveType = moveType;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
        this.targetOfMove = targetOfMove;

    }

    // Setter

    public void setAccuracy (double accuracy) {

        this.accuracy = accuracy;
    }

    public void setPriority (int priority) {

        this.priority = priority;
    }

    public void setAmmunition (int ammunition) {

        this.ammunition = ammunition;
    }

    // Getter Kelas Move

    public String getMoveType() {

        return moveType;
    }

    public ElementType getElementType() {

        return this.elementType;
    }

    public double getAccuracy() {

        return accuracy;
    }

    public int getPriority() {

        return priority;
    }

    public int getAmmunition() {

        return ammunition;
    }

    public TargetOfMove getTargetOfMove() {

        return targetOfMove;
    }

    public String getMoveName() {

        return moveName;
    }

    // Method

    public void useMove (Monster originMons, Monster targetMons) {

        // ini bakal dimasukin ke selectionMenu karena monster milih buat gerak.
    }
}


