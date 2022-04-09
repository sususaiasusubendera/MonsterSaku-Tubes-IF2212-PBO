package com.move;

import com.monster.ElementType;
import com.monster.Monster;

public class NormalMove extends Move {

    protected double basePower;
    protected int id;

    public NormalMove(int id, String moveName, ElementType elementType, int accuracy, int priority,
                      int ammunition, TargetOfMove targetOfMove, double basePower) {

        super(moveName, "NORMAL", elementType, accuracy, priority, ammunition, targetOfMove);
        this.id = id;
        this.basePower = basePower;

    }

    public double getBasePower() {

        return basePower;
    }

    // buat method untuk dapetin nilai damage

    public void normalMove(Monster originMons, Monster targetMons) {

        basePower = originMons.getBaseStats().getAttack() - targetMons.getBaseStats().getDefense();
        double newHP = targetMons.getBaseStats().getHealthPoint() - basePower;
        targetMons.getBaseStats().setHealthPoint(newHP);
    }
}


