package src.move;

import java.lang.annotation.ElementType;

public class StatusMove extends Move {

    private double basePower;


    public StatusMove(int id, String moveType, String name, ElementType elementType, int accuracy, int priority,
                      int ammunition, int basePower) {
        super(id, moveType, name, elementType, accuracy, priority, ammunition);
        this.basePower = basePower;
    }


}
