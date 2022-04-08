package com.move;

import com.monstersaku.Stats;
import com.monster.Monster;
import com.monster.ElementType;

public class NormalMove extends Move {

    private double basePower;

    public NormalMove(int id, ElementType elementType, int accuracy, int priority,
                      int ammunition) {

        super(id, "NORMAL", elementType, accuracy, priority, ammunition);

    }

    public double getBasePower() {

        return basePower;
    }

    // buat method untuk dapetin nilai damage

    public void normalMove(Monster originMons, Monster targetMons) {

        basePower = originMons.getBaseStats().getAttack() - targetMons.getBaseStats().getDefense();
        double newHP = target.getBaseStats().getHealthPoint() - basePower;
        targetMons.getBaseStats().setHealthPoint(newHP);
    }
}


