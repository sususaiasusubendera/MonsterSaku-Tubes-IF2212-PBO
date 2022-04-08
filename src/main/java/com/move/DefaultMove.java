package com.move;

import java.lang.*;
import com.monster.*;

public class DefaultMove {

    // Tipe serangan default adalah normal

    protected double basePower;

    public DefaultMove(int id, ElementType elementType, int accuracy, int priority,
                       int ammunition, TargetOfMove targetOfMove, double effect, double basePower) {

        super(id, "DEFAULT", elementType, 100, 0, 200, targetOfMove,effect);
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
