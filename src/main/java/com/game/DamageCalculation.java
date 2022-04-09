package com.game;

import com.monster.*;
import com.game.*;
import com.monstersaku.*;
import com.move.*;

public class DamageCalculation {
    public static void damageReceived(Player source, Player target, Move move1, Move move2) {
        
    }

    public static void afterDamage(Player target) {
        double maxHPMons = target.getCurrentMonster().getMaxHP();
        double statusMultiplier = 0;
        if (target.getCurrentMonster().getCondi().getStatCondi() == StatusCondition.BURN) {
            statusMultiplier = 1/8;
        } else {
            statusMultiplier = 1/16;
        }
        double damage = Math.floor(maxHPMons*statusMultiplier);
        double currHP = target.getCurrentMonster().getBaseStats().getHealthPoint();
        target.getCurrentMonster().getBaseStats().setHealthPoint(currHP-damage);
    }


}
