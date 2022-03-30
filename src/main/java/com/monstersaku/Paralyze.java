package com.monstersaku;

import java.util.Random;

public class Paralyze extends StatusCondition {
    // attribute
    private int baseSpeed = super.getPemilik().getBaseStats().getSpeed();

    // constructor
    public Paralyze(Monster poisoned) {
        super(poisoned);
    }
    public void paralyze(Monster paralyzed) {
        paralyzed.getBaseStats().setSpeed(baseSpeed*0.5);
        Random rand = new Random();
        int upperbound = 5;
        int chance = rand.nextInt(upperbound);
        if (chance == 1) {
            System.out.println("Ups, kamu tidak bisa bergerak karena PARALYZE");
        } else {
            // boleh gerak
        }
    }
}
