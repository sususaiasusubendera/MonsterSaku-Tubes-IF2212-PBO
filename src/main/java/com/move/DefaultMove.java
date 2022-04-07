package com.move;

import java.lang.*;

public class DefaultMove {

    // Tipe serangan default adalah normal

    private double basePower;

    public DefaultMove(int id,int accuracy, int priority,
                       int ammunition, double basePower) {

        super(id, "DEFAULT", elementType, 100, 0, 200);
        basePower = 50;

    }

    public double getBasePower() {

        return basePower;
    }

    public void defaultMove(Monster monster) {

        double newHP = monster.getBaseStats().getHealthPoint() - (Math.floor((1/4)*monster.getBaseStats().getHealthPoint()));
        monster.getBaseStats().setHealthPoint(newHP);
    }
}
