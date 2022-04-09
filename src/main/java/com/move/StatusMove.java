package com.move;

import com.monster.*;

public class StatusMove extends Move {

    protected String statsEffect; // nama nya aku ubah biar gak sama kayak effect yang double.
    protected double healHP;
    protected int id;

    public StatusMove(int id,String moveName, ElementType elementType, int accuracy, int priority,
                      int ammunition, TargetOfMove targetOfMove, String statsEffect, Double healHP) {

        super(moveName, "STATUS", elementType, accuracy, priority, ammunition,targetOfMove);
        this.id = id;
        this.statsEffect = statsEffect;
        this.healHP = healHP;
    }

    // Getter

    public String getEffect() {
        return statsEffect;
    }

    public double getHealHP() {
        return healHP;
    }

    // Setter

    public void setEffect(String statsEffect) {
        this.statsEffect = statsEffect;
    }

    public void setHealHP(double healHP) {
        this.healHP = healHP;
    }

    // Method

    public void statusMove(Monster originMons, Monster targetMons) {

        // Hanya memberikan dampak pada status condition
        // Menyembuhkan HP?? duh gakebayang

    }

}


