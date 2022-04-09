package com.game;

import java.util.Random;

import com.monster.*;
import com.game.*;
import com.monstersaku.*;
import com.move.*;

public class DamageCalculation {
    public static void normalDamage(Player source, Player target, NormalMove move) {
        double burnfactor;
        if(source.getCurrentMonster().getCondi().getStatCondi() == StatusCondition.BURN){
            burnfactor = 0.5;
        }
        else{
            burnfactor = 1;
        }
        Random rand = new Random();
        int randomInt = rand.nextInt(100-85) + 85;
        double ranDouble = randomInt/100;
        double damage = Math.floor((move.getBasePower()*(source.getCurrentMonster().getBaseStats().getAttack()/target.getCurrentMonster().getBaseStats().getDefense())+2)*(ranDouble)*(burnfactor));
        double newHP = target.getCurrentMonster().getBaseStats().getHealthPoint() - damage;
        target.getCurrentMonster().getBaseStats().setHealthPoint(newHP);
    }

    public static void specialDamage(Player source, Player target, SpecialMove move){
        double burnfactor;
        if(source.getCurrentMonster().getCondi().getStatCondi() == StatusCondition.BURN){
            burnfactor = 0.5;
        }
        else{
            burnfactor = 1;
        }
        Random rand = new Random();
        int randomInt = rand.nextInt(100-85) + 85;
        double ranDouble = randomInt/100;
        double damage = Math.floor((move.getBasePower()*(source.getCurrentMonster().getBaseStats().getSpecialAttack()/target.getCurrentMonster().getBaseStats().getSpecialDefense())+2)*(ranDouble)*(burnfactor));
        double newHP = target.getCurrentMonster().getBaseStats().getHealthPoint() - damage;
        target.getCurrentMonster().getBaseStats().setHealthPoint(newHP);
    }

    public static void defaultDamage(Player source, Player target, DefaultMove move) {
        double burnfactor;
        if(source.getCurrentMonster().getCondi().getStatCondi() == StatusCondition.BURN){
            burnfactor = 0.5;
        }
        else{
            burnfactor = 1;
        }
        Random rand = new Random();
        int randomInt = rand.nextInt(100-85) + 85;
        double ranDouble = randomInt/100;
        double damage = Math.floor((move.getBasePower()*(source.getCurrentMonster().getBaseStats().getAttack()/target.getCurrentMonster().getBaseStats().getDefense())+2)*(ranDouble)*(burnfactor));
        double newHP = target.getCurrentMonster().getBaseStats().getHealthPoint() - damage;
        target.getCurrentMonster().getBaseStats().setHealthPoint(newHP);
        move.defaultMove(source.getCurrentMonster());
    }


    public static void afterDamage(Player target) {
        double maxHPMons = target.getCurrentMonster().getMaxHP();
        double statusMultiplier = 0;
        if (target.getCurrentMonster().getCondi().getStatCondi() == StatusCondition.BURN) {
            statusMultiplier = 1/8;
        } else if (target.getCurrentMonster().getCondi().getStatCondi() == StatusCondition.POISON) {
            statusMultiplier = 1/16;
        } else {
            statusMultiplier = 0;
        }
        double damage = Math.floor(maxHPMons*statusMultiplier);
        double currHP = target.getCurrentMonster().getBaseStats().getHealthPoint();
        target.getCurrentMonster().getBaseStats().setHealthPoint(currHP-damage);
    }


}
