package com.monstersaku;

import java.util.Random;

public class Sleep extends StatusCondition {
    // constructor
    public Sleep(Monster sleeped) {
        super(sleeped);
    }
    // method
    public void sleep(Monster sleeped) {
        Random rand = new Random();
        int upperbound = 8;
        int x = rand.nextInt(upperbound);
// trs gatau diapain hehe
    }
}
