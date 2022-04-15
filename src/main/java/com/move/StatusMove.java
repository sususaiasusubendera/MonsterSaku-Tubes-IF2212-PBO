package com.move;

import com.player.*;
import com.monster.*;
import com.condition.*;

import java.util.Random;

public class StatusMove extends Move {

    protected int id;
    protected String statsEffect; 
    protected double healPercentage;
    protected int buffAttack;
    protected int buffDefense;
    protected int buffSpecialAttack;
    protected int buffSpecialDefense;
    protected int buffSpeed;

    public StatusMove(int id,String moveName, ElementType elementType, int accuracy, int priority,
                      int ammunition, TargetOfMove targetOfMove, String statsEffect, 
                      Double healPercentage, int buffAttack, int buffDefense, int buffSpecialAttack, int buffSpecialDefense, int buffSpeed) {

        super(moveName, "STATUS", elementType, accuracy, priority, ammunition,targetOfMove);
        this.id = id;
        this.statsEffect = statsEffect;
        this.healPercentage = healPercentage;
        this.buffAttack = buffAttack;
        this.buffDefense = buffDefense;
        this.buffSpecialAttack = buffSpecialAttack;
        this.buffSpecialDefense = buffSpecialDefense;
        this.buffSpeed = buffSpeed;
    }
    public StatusMove(StatusMove copiedStatusMove){
        super((Move)copiedStatusMove);
        this.id = copiedStatusMove.getId();
        this.statsEffect = copiedStatusMove.getEffect();
        this.healPercentage = copiedStatusMove.getHealPercentage();
        this.buffAttack = copiedStatusMove.getBuffAttack();
        this.buffDefense = copiedStatusMove.getBuffDefense();
        this.buffSpecialAttack = copiedStatusMove.getBuffSpecialAttack();
        this.buffSpecialDefense = copiedStatusMove.getBuffSpecialDefense();
        this.buffSpeed = copiedStatusMove.getBuffSpeed();
    }


    // Getter

    public int getId() {
        return id;
    }

    public String getEffect() {
        return statsEffect;
    }

    public double getHealPercentage() {
        return healPercentage;
    }

    public int getBuffAttack(){
        return buffAttack;
    }

    public int getBuffDefense(){
        return buffDefense;
    }

    public int getBuffSpecialAttack(){
        return buffSpecialAttack;
    }

    public int getBuffSpecialDefense(){
        return buffSpecialDefense;
    }

    public int getBuffSpeed(){
        return buffSpeed;
    }


    // Setter

    public void setId(int id) {
        this.id = id;
    }

    public void setEffect(String statsEffect) {
        this.statsEffect = statsEffect;
    }

    public void setHealPercentage(double healPercentage) {
        this.healPercentage = healPercentage;
    }

    public void setBuffAttack(int buffAttack){
        this.buffAttack = buffAttack;
    }

    public void setBuffDefense(int buffDefense){
        this.buffDefense = buffDefense;
    }

    public void setBuffSpecialAttack(int buffSpecialAttack){
        this.buffSpecialAttack = buffSpecialAttack;
    }

    public void setBuffSpecialDefense(int buffSpecialDefense){
        this.buffSpecialDefense = buffSpecialDefense;
    }

    public void setBuffSpeed(int buffSpeed){
        this.buffSpeed = buffSpeed;
    }


    // Method
    public void burn(Player target) {
        target.getCurrentMonster().getCondi().setStatCondi(StatusCondition.BURN);
    }

    public void poison(Player target) {
        target.getCurrentMonster().getCondi().setStatCondi(StatusCondition.POISON);
    }

    public void sleep(Player target) {
        target.getCurrentMonster().getCondi().setStatCondi(StatusCondition.SLEEP);
        // gabisa gerak selama x giliran
        Random rand = new Random();
        int upperbound = 7;
        int lowerbound = 1;
        int x = rand.nextInt(upperbound-lowerbound+1) + lowerbound;
        target.getCurrentMonster().getCondi().setSleepCount(x);
        System.out.println("Sleep sebanyak " + (x) + " giliran");
    }

    public void paralyze(Player target) {
        target.getCurrentMonster().getCondi().setStatCondi(StatusCondition.PARALYZE);
        // speed turun 50%
        double currSpeed = target.getCurrentMonster().getBaseStats().getSpeed();
        double newSpeed = currSpeed*0.5;
        target.getCurrentMonster().getBaseStats().setSpeed(newSpeed);
        System.out.printf("Speed berkurang 50%% dari %.1f menjadi %.1f\n", currSpeed, newSpeed);
        // mungkin gabisa gerak
        if (new Random().nextDouble() <= 0.25) {
            target.getCurrentMonster().getCondi().setCanMove(false);
            System.out.println("Tidak bisa bergerak di giliran selanjutnya karena kurang beruntung!");
        } else {
            System.out.println("Untung saja kamu masih boleh bergerak di giliran selanjutnya");
        }
    }
}


