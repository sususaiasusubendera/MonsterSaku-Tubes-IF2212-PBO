package com.condition;

public class Condition {
    private StatusCondition statcondi;
    private int sleepCount;
    private boolean canMove;

    // konstruktor
    public Condition() {
        this.statcondi = StatusCondition.NONE;
        this.sleepCount = 0;
        this.canMove = true;
    }
    // getter
    public StatusCondition getStatCondi() {
        return statcondi;
    }

    public int getSleepCount() {
        return sleepCount;
    }

    public boolean getCanMove() {
        return canMove;
    }

    // setter
    public void setStatCondi(StatusCondition statcondi) {
        this.statcondi = statcondi;
    }

    public void setSleepCount(int count) {
        this.sleepCount = count;
    }    

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }
    
}
