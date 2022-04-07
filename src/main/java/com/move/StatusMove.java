package com.move;

public class StatusMove extends Move {

    public StatusMove(int id, ElementType elementType, int accuracy, int priority,
                      int ammunition) {
        super(id, "STATUS", elementType, accuracy, priority, ammunition);
    }

    // Getter

    public void statusMove(Monster originMons, Monster targetMons) {

        // Hanya memberikan dampak pada status condition
        // Menyembuhkan HP?? duh gakebayang

    }

}




}
