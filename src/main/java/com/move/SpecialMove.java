package com.move;

import com.monstersaku.Stats;
import com.monster.*;

public class SpecialMove extends Move {

    protected double basePower;
    protected int id;


    public SpecialMove(int id, String moveType, ElementType elementType, int accuracy,
                       int priority, int ammunition, int basePower) {
        super(id,"SPECIAL", name, elementType, accuracy, priority, ammunition);
        this.basePower = basePower;
    }

    public double getBasePower() {

        return basePower;
    }

    public void specialMove(Monster originMons, Monster targetMons) {

        basePower = originMons.getBaseStats().getSpecialAttack() - targetMons.getBaseStats().getSpecialDefense();
        double newHP = targetMons.getHealthPoint() - basePower;
        originMons.getBaseStats().setHealthPoint(newHP);
    }



}
