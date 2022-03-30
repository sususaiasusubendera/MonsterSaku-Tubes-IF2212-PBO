package com.monstersaku;
public abstract class StatusCondition {
    // attribute
    private Monster pemilik;
    // constructor
    public StatusCondition(Monster pemilik) {
        this.pemilik = pemilik;
    }
    // method
    public Monster getPemilik() {
        return pemilik;
    }
    public void setPemilik(Monster monster) {
        this.pemilik = monster;
    }
}
