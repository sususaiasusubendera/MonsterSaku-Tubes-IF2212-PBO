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

    // Getter
    public double getBasePower() {
        return basePower;
    }

    // Setter
    public void setBasePower(double basePower) {
        this.basePower = basePower;
    }


    // buat method untuk dapetin nilai damage calculation

    public void normalMove(Monster originMons, Monster targetMons) {

        double damage = originMons.getBaseStats().getAttack() - targetMons.getBaseStats().getDefense();
        double newHP = targetMons.getBaseStats().getHealthPoint() - damage;
        targetMons.getBaseStats().setHealthPoint(newHP);
    }

    /***
     *
     * Rumus damage calculation pada normal move
     * - use stats attack
     * - use stats defense
     *
     *
     */
}


