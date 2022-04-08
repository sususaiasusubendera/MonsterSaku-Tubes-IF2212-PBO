package com.move;

import com.monster.ElementType;
import com.monster.Monster;

public class Move {

    protected int id;
    protected String moveType;
    protected ElementType elementType;
    protected int accuracy;
    protected int priority;
    protected int ammunition;
    protected TargetOfMove targetOfMove;
    protected double effect;


    // Konstruktor Kelas Move
    // id berisi bilangan bulat positif unik

    public Move(int id, String moveType, ElementType elementType,int accuracy,
                int priority, int ammunition, TargetOfMove targetOfMove, double effect, ) {

        this.id = id;
        this.moveType = moveType;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;

    }

    // Setter Kelas Move

    public void setId (int id) {

        this.id = id;
    }

    // Tipe elemen yang dimiliki oleh move
    // Dapat menentukan efektivitasnya terhadap target monster.
    public void setElementType (ElementType elementType) {

        this.elementType = elementType;

    }

    public void setAccuracy (int accuracy) {

        this.accuracy = accuracy;

    }

    public void setPriority (int priority) {

        this.priority = priority;

    }

    public void setAmmunition (int ammunition) {

        this.ammunition = ammunition;
    }

    // Getter Kelas Move

    public int getId() {

        return id;
    }

    public String getMoveType() {

        return moveType;
    }


    public ElementType getElementType() {

        return this.elementType;
    }

    public int getAccuracy() {

        return accuracy;

    }

    public int getPriority() {

        return priority;

    }

    public int getAmmunition() {

        return ammunition;

    }

    // Method

    public void useMove (Monster originMons, Monster targetMons) {

        // ini bakal dimasukin ke selectionMenu karena monster milih buat gerak.
    }
}


