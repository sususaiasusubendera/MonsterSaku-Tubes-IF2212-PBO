package com.move;

import com.monster.*;

public class StatusMove extends Move {

    protected String effect;
    protected double healHP;

    public StatusMove(int id, String name, ElementType elementType, int accuracy, int priority,
                      int ammunition, String effect, Double healHP) {
        super(id, name, "STATUS", elementType, accuracy, priority, ammunition);
        this.effect = effect;
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


