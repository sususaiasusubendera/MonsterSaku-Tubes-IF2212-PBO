package com.move;

import com.monster.*;

public class StatusMove extends Move {

    private String effect;
    private Double healHP;

<<<<<<< HEAD
    public StatusMove(int id, String name, ElementType elementType, int accuracy, int priority,
                      int ammunition, String effect, Double healHP) {
        super(id, name, "STATUS", elementType, accuracy, priority, ammunition);
        this.effect = effect;
        this.healHP = healHP;
=======
    public StatusMove(int id, ElementType elementType, int accuracy, int priority,
                      int ammunition, TargetOfMove targetOfMove, double effect) {
        super(id, "STATUS", elementType, accuracy, priority, ammunition, targetOfMove, effect);
>>>>>>> 866735d7867eec97902a55d80daadcda22af1d96
    }

    // Getter

    public void statusMove(Monster originMons, Monster targetMons) {

        // Hanya memberikan dampak pada status condition
        // Menyembuhkan HP?? duh gakebayang

    }

    public String getEffect() {
        return effect;
    }

    public Double getHealHP() {
        return healHP;
    }

    // Setter
    public void setEffect(String effect) {
        this.effect = effect;
    }

    public void setHealHP(Double healHP) {
        this.healHP = healHP;
    }

}


