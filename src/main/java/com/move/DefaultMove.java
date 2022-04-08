package com.move;

import java.lang.*;

public class DefaultMove {

    // Tipe serangan default adalah normal

    private double basePower;

    public DefaultMove(int id, String name, int accuracy, int priority,
                       double basePower) {

        super(id, name, "DEFAULT", elementType, 100, 0, 50);
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
