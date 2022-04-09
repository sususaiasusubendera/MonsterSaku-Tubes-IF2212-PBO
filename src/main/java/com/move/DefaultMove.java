package com.move;

import java.lang.*;

public class DefaultMove {

    // Tipe serangan default adalah normal

    private double basePower;

    public DefaultMove() {

        
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
