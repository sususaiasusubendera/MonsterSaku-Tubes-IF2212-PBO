package com.move;

import com.monster.ElementType;

public class NormalMove extends Move {

    protected double basePower;
    protected int id;

    public NormalMove(int id, String moveName, ElementType elementType, int accuracy, int priority,
                      int ammunition, TargetOfMove targetOfMove, double basePower) {

        super(moveName, "NORMAL", elementType, accuracy, priority, ammunition, targetOfMove);
        this.id = id;
        this.basePower = basePower;

    }
    public NormalMove(NormalMove copiedNormalMove){
        super((Move)copiedNormalMove);
        this.id = copiedNormalMove.getId();
        this.basePower = copiedNormalMove.getBasePower();
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


