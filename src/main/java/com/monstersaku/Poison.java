package com.monstersaku;

import com.monster.*;

public class Poison extends StatusCondition {
    // attribute
    private int MaxHP = super.getPemilik().getBaseStats().getHP();

    // constructor
    public Poison(Monster poisoned) {
        super(poisoned);
    }
    
    // method
    public void poison(Monster poisoned) {
        poisoned.getBaseStats().setHP(poisoned.getBaseStats().getHP() - (MaxHP*0.0625));
    }
}
