package com.move;
import com.monster.ElementType;
import com.monster.Monster;

public class StatusMove extends Move {

    protected String effect;
    protected Double healHP;

    public StatusMove(int id, ElementType elementType, int accuracy, int priority,
                      int ammunition, TargetOfMove targetOfMove, double effect) {
        super(id, "STATUS", elementType, accuracy, priority, ammunition, targetOfMove, effect);
    }

    // Getter

    public void statusMove(Monster originMons, Monster targetMons) {

        // Hanya memberikan dampak pada status condition
        // Menyembuhkan HP?? duh gakebayang

    }

}
