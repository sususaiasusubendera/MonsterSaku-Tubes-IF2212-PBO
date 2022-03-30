package com.monstersaku;
public class Burn extends StatusCondition {
    // attribute
    private int MaxHP = super.getPemilik().getBaseStats().getHP();

    // constructor
    public Burn(Monster burned) {
        super(burned);
    }
    public void burn(Monster burned) {
        burned.getBaseStats().setHP(burned.getBaseStats().getHP() - (MaxHP*0.125));
        burned.getBaseStats().setAttack((burned.getBaseStats().getAttack())*0.5);
    }
}
