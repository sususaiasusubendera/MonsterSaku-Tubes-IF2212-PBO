package com.move;

import com.monster.*;
import com.player.Player;

public class DefaultMove extends Move {

    // Tipe serangan default adalah normal

    private final double basePower; // Gk bisa di apa2in lagi

    public DefaultMove() {

        super("DEFAULT", "NORMAL", ElementType.NORMAL, 100, 0, 50, TargetOfMove.ENEMY);
        this.basePower = 50;
    }
    public DefaultMove(DefaultMove copiedDefaultMove){
        super((Move)copiedDefaultMove);
        this.basePower = copiedDefaultMove.getBasePower();
    }


    public double getBasePower() {

        return basePower;
    }

    public void defaultMove(Player p) {
        double defaultdamage = Math.floor((1.0/4.0)*p.getCurrentMonster().getMaxHP());
        double newHP = p.getCurrentMonster().getBaseStats().getHealthPoint() - defaultdamage;
        if (newHP <= 0) {
            p.getCurrentMonster().getBaseStats().setHealthPoint(0);
        } else {
            p.getCurrentMonster().getBaseStats().setHealthPoint(newHP);
        }
    }
}
