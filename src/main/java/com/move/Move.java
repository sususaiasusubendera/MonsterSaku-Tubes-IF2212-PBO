package com.move;

public class Move {

    private int id;
    private String moveType;
    private ElementType elementType;
    private int accuracy;
    private int priority;
    private int ammunition;

    // Konstruktor Kelas Move
    // id berisi bilangan bulat positif unik

    public Move(int id, String moveType, ElementType elementType,int accuracy,
                int priority, int ammunition) {

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
}
