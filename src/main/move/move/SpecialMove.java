package move;

import java.lang.annotation.ElementType;

public class SpecialMove extends Move {

    private int basePower;

    public SpecialMove(int id, String moveType, String name, ElementType elementType, int accuracy,
                       int priority, int ammunition, int basePower) {
        super(id, moveType, name, elementType, accuracy, priority, ammunition);
        this.basePower = basePower;
    }


    public int getBasePower() {

        return basePower;
    }

   // public void specialMove() {



}
