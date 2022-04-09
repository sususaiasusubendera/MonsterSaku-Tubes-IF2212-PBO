package com.move;

import com.monster.*;
import java.lang.*;

public class DefaultMove extends Move {

    // Tipe serangan default adalah normal

    private final double basePower;

    public DefaultMove(int id, String moveName, ElementType elementType, TargetOfMove targetOfMove, double effect, double basePower) {

        super(id, moveName, "DEFAULT", elementType, 100, 0, 50,targetOfMove, effect)
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
