package com.move;

import com.monster.*;

public class StatusMove extends Move {

    protected String statsEffect; // nama nya aku ubah biar gak sama kayak effect yang double.
    protected double healHP;

    public StatusMove(int id, String moveName, ElementType elementType, int accuracy, int priority,
                      int ammunition, TargetOfMove targetOfMove, double effect, String statsEffect, Double healHP) {
        super(id,"STATUS",moveName, elementType, accuracy, priority, ammunition, targetOfMove, effect);
        this.statsEffect = statsEffect;
        this.healHP = healHP;
    }

    // Getter

    public void statusMove(Monster originMons, Monster targetMons) {

        // Hanya memberikan dampak pada status condition
        // Menyembuhkan HP?? duh gakebayang

    }

    public String getEffect() {
        return effect;
    }

    public double getHealHP() {
        return healHP;
    }

    // Setter

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public void setHealHP(double healHP) {
        this.healHP = healHP;
    }

}


