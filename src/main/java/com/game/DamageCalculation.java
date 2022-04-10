package com.game;

import com.monster.*;
import com.monstersaku.*;
import com.move.*;
import java.util.*;

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
        int randomInt = rand.nextInt(100-85+1) + 85;
        double dobel = randomInt;
        double ranDouble = dobel/100;
        double effectivity = damageEffectivity(target, move);
        double damage = Math.floor((move.getBasePower()*(source.getCurrentMonster().getBaseStats().getAttack()/target.getCurrentMonster().getBaseStats().getDefense())+2)*(ranDouble)*effectivity*(burnfactor));
        double newHP = target.getCurrentMonster().getBaseStats().getHealthPoint() - damage;
        if (newHP < 0) {
            target.getCurrentMonster().getBaseStats().setHealthPoint(0);
        } else {
            target.getCurrentMonster().getBaseStats().setHealthPoint(newHP);
        }
        System.out.println(target.getCurrentMonster().getNama() + " terkurangi HP sebesar " + damage);
        System.out.println("HP baru: " + target.getCurrentMonster().getBaseStats().getHealthPoint());
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
        int randomInt = rand.nextInt(100-85+1) + 85;
        double dobel = randomInt;
        double ranDouble = dobel/100;
        double effectivity = damageEffectivity(target, move);
        double damage = Math.floor((move.getBasePower()*(source.getCurrentMonster().getBaseStats().getSpecialAttack()/target.getCurrentMonster().getBaseStats().getSpecialDefense())+2)*(ranDouble)*effectivity*(burnfactor));
        double newHP = target.getCurrentMonster().getBaseStats().getHealthPoint() - damage;
        if (newHP < 0) {
            target.getCurrentMonster().getBaseStats().setHealthPoint(0);
        } else {
            target.getCurrentMonster().getBaseStats().setHealthPoint(newHP);
        }
        System.out.println(target.getCurrentMonster().getNama() + " terkurangi HP sebesar " + damage);
        System.out.println("HP baru: " + target.getCurrentMonster().getBaseStats().getHealthPoint());
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
        int randomInt = rand.nextInt(100-85+1) + 85;
        double dobel = randomInt;
        double ranDouble = dobel/100;
        double effectivity = damageEffectivity(target, move);
        double damage = Math.floor((move.getBasePower()*(source.getCurrentMonster().getBaseStats().getAttack()/target.getCurrentMonster().getBaseStats().getDefense())+2)*(ranDouble)*effectivity*(burnfactor));
        double newHP = target.getCurrentMonster().getBaseStats().getHealthPoint() - damage;
        if (newHP < 0) {
            target.getCurrentMonster().getBaseStats().setHealthPoint(0);
        } else {
            target.getCurrentMonster().getBaseStats().setHealthPoint(newHP);
        }
        move.defaultMove(source.getCurrentMonster());
        System.out.println(target.getCurrentMonster().getNama() + " terkurangi HP sebesar " + damage);
        System.out.println("HP baru: " + target.getCurrentMonster().getBaseStats().getHealthPoint());
    }


    public static void afterDamage(Player target) {
        double maxHPMons = target.getCurrentMonster().getMaxHP();
        double statusMultiplier = 0;
        if (target.getCurrentMonster().getCondi().getStatCondi() == StatusCondition.BURN) {
            statusMultiplier = 1/8;
            System.out.println(target.getCurrentMonster().getNama() + " masih punya BURN");
        } else if (target.getCurrentMonster().getCondi().getStatCondi() == StatusCondition.POISON) {
            statusMultiplier = 1/16;
            System.out.println(target.getCurrentMonster().getNama() + " masih punya POISON");
        } else {
            statusMultiplier = 0;
        }
        double damage = Math.floor(maxHPMons*statusMultiplier);
        double currHP = target.getCurrentMonster().getBaseStats().getHealthPoint();
        target.getCurrentMonster().getBaseStats().setHealthPoint(currHP-damage);
        System.out.println("HP saat ini: " + target.getCurrentMonster().getBaseStats().getHealthPoint());
    }

    public static double damageEffectivity(Player target, Move moveSource) {
        ElementType elTypeMove = moveSource.getElementType();
        String stringETMove = elTypeMove.name();
        List<ElementType> monsterElements = target.getCurrentMonster().getElementTypes();
        List<String> pairElTypes = new ArrayList<String>();
        for (ElementType et : monsterElements) {
            String pairString = stringETMove+et.name();
            pairElTypes.add(pairString);
        }
        double totalEffectivity = 1;
        for (String key : pairElTypes) {
            if (Reader.getGameMapEffectivity().containsKey(key)) {
                totalEffectivity = totalEffectivity * Reader.getGameMapEffectivity().get(key);
            }
        }
        return totalEffectivity;
    }
}
