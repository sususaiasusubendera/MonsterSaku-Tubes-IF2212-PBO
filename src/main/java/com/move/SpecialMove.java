package com.move;

import com.monster.ElementType;
import com.monster.Monster;

public class SpecialMove extends Move {

    protected double basePower;
    protected int id;


    public SpecialMove(int id, String moveName, String moveType, ElementType elementType, int accuracy,
                       int priority, int ammunition, TargetOfMove targetOfMove, double basePower) {
        super(moveName, "SPECIAL", elementType, accuracy, priority, ammunition, targetOfMove);
        this.id = id;
        this.basePower = basePower;
    }

    // Getter
    public double getBasePower() {
        return basePower;
    }

    // Setter
    public void setBasePower(double basePower) {
        this.basePower = basePower;
    }

    public void specialMove(Monster originMons, Monster targetMons) {

        double damage = originMons.getBaseStats().getSpecialAttack() - targetMons.getBaseStats().getSpecialDefense();
        double newHP = targetMons.getBaseStats().getHealthPoint() - damage;
        originMons.getBaseStats().setHealthPoint(newHP);
    }



}
