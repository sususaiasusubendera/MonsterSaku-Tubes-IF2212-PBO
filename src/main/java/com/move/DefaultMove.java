package com.move;

import com.monster.*;

public class DefaultMove extends Move {

    // Tipe serangan default adalah normal

    private final double basePower; // Gk bisa di apa2in lagi

    public DefaultMove() {

        super("DEFAULT", "NORMAL", ElementType.NORMAL, 100, 0, 50, TargetOfMove.ENEMY);
        this.basePower = 50;
    }
    public DefaultMove(DefaultMove copiedDefaultMove){
        super((Move)copiedDefaultMove);
        this.basePower = copiedDefaultMove.getBasePower();
    }


    public double getBasePower() {

        return basePower;
    }

    public void defaultMove(Monster monster) {

        double newHP = monster.getBaseStats().getHealthPoint() - (Math.floor((1.0/4.0)*monster.getMaxHP()));
        monster.getBaseStats().setHealthPoint(newHP);
    }
}
