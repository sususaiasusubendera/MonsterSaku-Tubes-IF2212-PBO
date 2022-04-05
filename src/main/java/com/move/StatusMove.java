package com.move;

public class StatusMove extends Move {

    private double basePower;


    public StatusMove(int id, String moveType, String name, ElementType elementType, int accuracy, int priority,
                      int ammunition, int basePower) {
        super(id, "STATUS" , elementType, accuracy, priority, ammunition);
        this.basePower = basePower;
    }

    // Getter

    public double getBasePower() {
        return basePower;
    }

    public void
}
