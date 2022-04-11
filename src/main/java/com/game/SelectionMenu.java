package com.game;

import com.monster.Monster;
import com.monstersaku.StatusCondition;
import com.move.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// selection menu aku masukin semua method jadinya,, kayanya namanya sabi diubah tp kalo males gausa HEHE sorry
public class SelectionMenu {
    static Scanner scanner = new Scanner(System.in);


    public static Move chooseMove(Player p) {
        
        System.out.println("Pilih move: ");
        p.getCurrentMonster().printMoves();
        System.out.println("[0] Default Move");
        System.out.printf("Pilihan move: ");
        int movePick = scanner.nextInt();
        if (movePick != 0) {
            int currAmmo = p.getCurrentMonster().getMoves().get(movePick-1).getAmmunition();
            p.getCurrentMonster().getMoves().get(movePick-1).setAmmunition(currAmmo-1);
            return (p.getCurrentMonster().getMoves().get(movePick-1));
        } else {
            return (new DefaultMove());
        }
    }


    public static void chooseMonster(Player p) {
        
        System.out.println("Pilih monster: ");
        p.printMonsters();
        System.out.printf("Pilihan monster: ");
        int monsPick = scanner.nextInt();
        p.setCurrentMonster(p.getListOfMonster().get(monsPick-1));

        /*** ini gk perlu gk sih? soalnya kalo monsternya mati dihapus dari list
        if (p.getListOfMonster().get(monsPick-1).getBaseStats().getHealthPoint() == 0) {
            System.out.println("Sorry, monsternya udah mati");
            SelectionMenu.chooseMonster(p);
        } else {
            p.setCurrentMonster(p.getListOfMonster().get(monsPick-1));
        }
        ***/
    }


// ini usemove blm beres
    public static void useMove(Player source, Player target, Move move) {
        System.out.println(source.getName() + " menggunakan " + move.getMoveName());
        double dob = new Random().nextDouble();
        double accuracy = move.getAccuracy()/100;
        if (dob <= accuracy) {
            if(move.getTargetOfMove() == TargetOfMove.OWN) {
                if (move instanceof StatusMove) {
                    StatusMove statusMove = (StatusMove)move;
                    double currHP = source.getCurrentMonster().getBaseStats().getHealthPoint();
                    double healHP = source.getCurrentMonster().getMaxHP()*statusMove.getHealPercentage()/100;
                    double newHP = currHP + healHP;
                    if (newHP >= source.getCurrentMonster().getMaxHP()) {
                        source.getCurrentMonster().getBaseStats().setHealthPoint(source.getCurrentMonster().getMaxHP());
                    } else {
                        source.getCurrentMonster().getBaseStats().setHealthPoint(currHP + healHP);
                    }
                    System.out.println("Mendapatkan heal " + healHP +"%");
                    System.out.println("HP sekarang: " + source.getCurrentMonster().getBaseStats().getHealthPoint());
                }
            } else if (move.getTargetOfMove() == TargetOfMove.ENEMY) {
                if (move instanceof NormalMove) {
                    NormalMove normalMove = (NormalMove)move;
                    DamageCalculation.normalDamage(source, target, normalMove);
                } else if (move instanceof SpecialMove) {
                    SpecialMove specialMove = (SpecialMove)move;
                    DamageCalculation.specialDamage(source, target, specialMove);
                } else if (move instanceof DefaultMove) {
                    DefaultMove defaultMove = (DefaultMove)move;
                    DamageCalculation.defaultDamage(source, target, defaultMove);
                } else if (move instanceof StatusMove) {
                    StatusMove statusMove = (StatusMove)move;
                    if (target.getCurrentMonster().getCondi().getStatCondi() == StatusCondition.NONE) {
                        if (statusMove.getEffect().equals("BURN")) {
                            System.out.println(target.getCurrentMonster().getNama() + " milik " + target.getName() + " terkena BURN");
                            statusMove.burn(target);
                        } else if (statusMove.getEffect().equals("POISON")) {
                            System.out.println(target.getCurrentMonster().getNama() + " milik " + target.getName() + " terkena POISON");
                            statusMove.poison(target);
                        } else if (statusMove.getEffect().equals("SLEEP")) {
                            System.out.println(target.getCurrentMonster().getNama() + " milik " + target.getName() + " terkena SLEEP");
                            statusMove.sleep(target);
                        } else if (statusMove.getEffect().equals("PARALYZE")) {
                            System.out.println(target.getCurrentMonster().getNama() + " milik " + target.getName() + " terkena PARALYZE");
                            statusMove.paralyze(target);
                        }
                    } else {
                        System.out.println("Monster sudah memiliki Status Condition! Move gagal");
                    }
                }
            }

            // hapus move dari list kalo ammunition udah abis
            if (move.getAmmunition() == 0){
                for (Move m : source.getCurrentMonster().getMoves()) {
                    if (m.equals(move)) {
                        source.getCurrentMonster().getMoves().remove(m);
                    }
                }
            }
        } else {
            System.out.println("Player " + source.getName() + "gagal melakukan move karena kurang beruntung");
        }
    }


    // kalau kedua player sama-sama move
    public static void battle(Player gofirst, Player gosecond, Move movefirst, Move movesecond) {
        SelectionMenu.useMove(gofirst, gosecond, movefirst);
        if (gosecond.getCurrentMonster().getBaseStats().getHealthPoint() <= 0) {
            gosecond.removeCurrMonster();
        } else {
            SelectionMenu.useMove(gosecond, gofirst, movesecond);
            if (gofirst.getCurrentMonster().getBaseStats().getHealthPoint() <= 0) {
                gofirst.removeCurrMonster();
            }
        }
    }


    // ngecekin ada yg sleep atau ga, kalo ada, kurangin sleepCount semuanya tiap abis giliran
    public static void decrementSleepCount(Player p) {
        for (Monster m : p.getListOfMonster()) {
            int currSC = m.getCondi().getSleepCount();
            if (currSC > 0) {
                m.getCondi().setSleepCount(currSC-1);
                if (currSC == 0) {
                    m.getCondi().setStatCondi(StatusCondition.NONE);
                }
            }
        }
    }

}
