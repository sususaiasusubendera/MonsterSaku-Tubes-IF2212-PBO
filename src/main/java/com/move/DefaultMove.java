package com.move;

import com.monster.*;
import java.lang.*;

public class DefaultMove extends Move {

    // Tipe serangan default adalah normal

    private final double basePower; // Gk bisa di apa2in lagi

    public DefaultMove() {

        super("DEFAULT", "DEFAULT", ElementType.NORMAL, 100, 0, 50, TargetOfMove.ENEMY);
        this.basePower = 50;
    }

    public double getBasePower() {

        return basePower;
    }

    public void defaultMove(Monster monster) {

        double newHP = monster.getBaseStats().getHealthPoint() - (Math.floor((1/4)*monster.getBaseStats().getHealthPoint()));
        monster.getBaseStats().setHealthPoint(newHP);
    }
}
