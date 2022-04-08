package com.game;

import com.monster.*;
import java.util.*;
import com.move.*;

public class SelectionMenu {
    static Scanner scanner = new Scanner(System.in);
    public static Move chooseMove(Player p) {
        
        System.out.println("Pilih move: ");
        p.getCurrentMonster().printMoves();
        System.out.println("[0] Default Move");
        int movePick = scanner.nextInt();

        if (movePick != 0) {
            if (p.getCurrentMonster().getMoves().get(movePick-1).getAmmunition() > 0) {
                return (p.getCurrentMonster().getMoves().get(movePick-1));
            } else {
                System.out.println("Sorry, ammunitionnya udah abis");
                SelectionMenu.chooseMove(p);
            }
        } else {
            return (new DefaultMove());
        }
    }

    public static void chooseMonster(Player p) {
        
        System.out.println("Pilih monster: ");
        p.printMonsters();
        int monsPick = scanner.nextInt();
        if (p.getListOfMonster().get(monsPick-1).getBaseStats().getHealthPoint() == 0) {
            System.out.println("Sorry, monsternya udah mati");
            SelectionMenu.chooseMonster(p);
        } else {
            p.setCurrentMonster(p.getListOfMonster().get(monsPick-1));
        }
    }

    public void useMove(Player source, Player target, Move move) {
        if (new Random().nextDouble() <= (move.getAccuracy()/100)) {
            if(move.getTarget() == TargetOfMove.OWN) {
                if (move instanceof StatusMove) {
                    StatusMove statusMove = (StatusMove)move;
                    double currHP = source.getCurrentMonster().getBaseStats().getHealthPoint();
                    source.getCurrentMonster().getBaseStats().setHealthPoint(currHP + statusMove.getHealHP());
                }
            } else if (move.getTarget() == TargetOfMove.ENEMY) {
                if (move instanceof NormalMove) {
                    NormalMove normalMove = (NormalMove)move;
                    // damage calculation menyusulll
                } else if (move instanceof SpecialMove) {
                    SpecialMove specialMove = (SpecialMove)move;
                    // damage calcu mnyusul
                } else if (move instanceof DefaultMove) {
                    //aaaaaaaaaaaaaaaaaaaaaa
                }
            } // dibuat sesuatu semacam useMove????
        } else {
            System.out.println("Player " + source.getName() + "gagal melakukan move karena kurang beruntung");
        }
    }
}
