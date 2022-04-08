package com.game;

import com.monster.*;

public class Turn {

    public void useMove(Monster currMons) {
        System.out.println("Pada giliran ini kamu akan melakukan Move!");
        currMons.chooseMove(currMons);
    }

    public void useSwitch(Player currPlayer) {

        System.out.println("Pada giliran ini kamu akan melakukan Switch!");
        currPlayer.chooseMonster(currPlayer);
    }

}
