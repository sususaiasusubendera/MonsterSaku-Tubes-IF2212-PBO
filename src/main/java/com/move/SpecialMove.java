package com.move;

import com.monster.ElementType;

public class SpecialMove extends Move {

    protected double basePower;
    protected int id;


    public SpecialMove(int id, String moveName, String moveType, ElementType elementType, int accuracy,
                       int priority, int ammunition, TargetOfMove targetOfMove, double basePower) {
        super(moveName, "SPECIAL", elementType, accuracy, priority, ammunition, targetOfMove);
        this.id = id;
        this.basePower = basePower;
    }
    public SpecialMove(SpecialMove copiedSpecialMove){
        super((Move)copiedSpecialMove);
        this.id = copiedSpecialMove.getId();
        this.basePower = copiedSpecialMove.getBasePower();
    }

    // Getter
    public double getBasePower() {
        return basePower;
    }

    public int getId() {
        return id;
    }

    // Setter
    public void setBasePower(double basePower) {
        this.basePower = basePower;
    }

    public void setId(int id) {
        this.id = id;
    }

}
