package com.game;

import com.monster.*;

public class Turn {

    public void useMove(Monster player) {
        System.out.println("Pada giliran ini kamu akan melakukan Move!");
        player.chooseMove();
    }

    public void useSwitch(Monster player) {

        System.out.println("Pada giliran ini kamu akan melakukan Switch!");
        player.chooseSwitch();
    }

}
