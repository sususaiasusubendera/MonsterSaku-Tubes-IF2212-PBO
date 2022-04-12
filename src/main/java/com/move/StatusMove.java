package com.move;

import com.player.*;
import com.monster.*;
import com.monstersaku.StatusCondition;

import java.util.Random;

public class StatusMove extends Move {

    protected String statsEffect; // nama nya aku ubah biar gak sama kayak effect yang double.
    protected double healPercentage;
    protected int id;

    public StatusMove(int id,String moveName, ElementType elementType, int accuracy, int priority,
                      int ammunition, TargetOfMove targetOfMove, String statsEffect, Double healPercentage) {

        super(moveName, "STATUS", elementType, accuracy, priority, ammunition,targetOfMove);
        this.id = id;
        this.statsEffect = statsEffect;
        this.healPercentage = healPercentage;
    }
    public StatusMove(StatusMove copiedStatusMove){
        super((Move)copiedStatusMove);
        this.id = copiedStatusMove.getId();
        this.statsEffect = copiedStatusMove.getEffect();
        this.healPercentage = copiedStatusMove.getHealPercentage();
    }

    // Getter

    public String getEffect() {
        return statsEffect;
    }

    public double getHealPercentage() {
        return healPercentage;
    }

    public int getId() {
        return id;
    }

    // Setter

    public void setEffect(String statsEffect) {
        this.statsEffect = statsEffect;
    }

    public void setHealPercentage(double healPercentage) {
        this.healPercentage = healPercentage;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Method
    public void burn(Player target) {
        target.getCurrentMonster().getCondi().setStatCondi(StatusCondition.BURN);
        // damage output kurang 50%
        // ini diimplementasi pas nyerang gt kah? brrti kudu cek dulu dia burn apa tydak
        // yg after damage udah ada calculationnya di damagecalculation
    }

    public void poison(Player target) {
        target.getCurrentMonster().getCondi().setStatCondi(StatusCondition.POISON);
        // yg after damage udah ada calculationnya di damagecalculation
    }

    public void sleep(Player target) {
        target.getCurrentMonster().getCondi().setStatCondi(StatusCondition.SLEEP);
        // gabisa gerak selama x giliran
        Random rand = new Random();
        int upperbound = 8;
        int x = rand.nextInt(upperbound-1) + 1;
        target.getCurrentMonster().getCondi().setSleepCount(x+1);
        System.out.println("Sleep sebanyak " + (x+1) + " giliran");
    }

    public void paralyze(Player target) {
        target.getCurrentMonster().getCondi().setStatCondi(StatusCondition.PARALYZE);
        // speed turun 50%
        double currSpeed = target.getCurrentMonster().getBaseStats().getSpeed();
        target.getCurrentMonster().getBaseStats().setSpeed(currSpeed*0.5);
        // mungkin gabisa gerak
        if (new Random().nextDouble() <= 0.25) {
            target.getCurrentMonster().getCondi().setCanMove(false);
            System.out.println("Tidak bisa bergerak di giliran selanjutnya!");
        }
        // GIMANA BIAR ABIS SEKALI GAGAL MOVE, ABIS ITU BOLEH MOVE LAGI?
    }
}


