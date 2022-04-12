package com.game;

import com.player.*;
import com.monster.Monster;
import com.condition.*;
import com.move.*;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

// selection menu aku masukin semua method jadinya,, kayanya namanya sabi diubah tp kalo males gausa HEHE sorry
public class SelectionMenu {
    static Scanner scanner = new Scanner(System.in);


    public static Move chooseMove(Player p) {
        
        int movePick = -1;
        Move m = null;
        do {
            try{
                System.out.println("Pilih move: ");
                p.getCurrentMonster().printMoves();
                System.out.println("[0] Default Move");
                System.out.printf("Pilihan move: ");
                movePick = scanner.nextInt();
                System.out.println("");
                if (movePick >= 0 && movePick <= p.getCurrentMonster().getMoves().size()){
                    if (movePick != 0) {
                        int currAmmo = p.getCurrentMonster().getMoves().get(movePick-1).getAmmunition();
                        p.getCurrentMonster().getMoves().get(movePick-1).setAmmunition(currAmmo-1);
                        m = (p.getCurrentMonster().getMoves().get(movePick-1));
                    } else {
                        m = (new DefaultMove());
                    }
                } else{
                    System.out.println("--- Masukan salah, tolong diulang ya ---");
                }
            } catch (InputMismatchException e){
                System.out.println("");
                System.out.println("--- Masukan salah, tolong diulang ya ---");
                scanner.next();
                continue;
            }
        } while (movePick < 0 || movePick > p.getCurrentMonster().getMoves().size());
        return m;
    }


    public static void chooseMonster(Player p) {
        
        int monsPick = 0;
        do {
            try{
                System.out.println("Pilih monster: ");
                p.printMonsters();
                System.out.printf("Pilihan monster: ");
                monsPick = scanner.nextInt();
                System.out.println("");
                if (monsPick >= 1 && monsPick <= p.getNumberOfMonster()){
                    p.setCurrentMonster(p.getListOfMonster().get(monsPick-1));   
                } else{
                    System.out.println("--- Masukan salah, tolong diulang ya ---");
                }
            } catch (InputMismatchException e){
                System.out.println("");
                System.out.println("--- Masukan salah, tolong diulang ya ---");
                scanner.next();
                continue;
            }
        } while (monsPick < 1 || monsPick > p.getNumberOfMonster());
    }


// ini usemove blm beres
    public static void useMove(Player source, Player target, Move move) {
        System.out.println(source.getName() + " menggunakan " + move.getMoveName());
        double dob = new Random().nextDouble();
        double accuracy = move.getAccuracy()/100;
        /*** Debug Accuracy
        System.out.println("dob = " + dob);
        System.out.println("acc = " + accuracy);
        System.out.println("mov : " + (dob<=accuracy));
        ***/
        if (dob <= accuracy) {
            if(move.getTargetOfMove() == TargetOfMove.OWN) {
                if (move instanceof StatusMove) {
                    StatusMove statusMove = (StatusMove)move;
                    if (statusMove.getHealPercentage() > 0){
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
                    } else {
                        buffMonster(source, statusMove);
                    }
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
                    if (statusMove.getEffect().equals("-")){
                        buffMonster(target, statusMove);
                    } else{
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
            System.out.println("Player " + source.getName() + " gagal melakukan move karena kurang beruntung");
        }
        System.out.println("");
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


    // Fungsi Buff Factor (untuk semua buff)
    public static double buffFactor(int buff){
        double value;
        switch (buff) {
            case -4: value = 2.0/6.0; break;
            case -3: value = 2.0/5.0; break;
            case -2: value = 2.0/4.0; break;
            case -1: value = 2.0/3.0; break;
            case  0: value = 1.0;     break;
            case  1: value = 3.0/2.0; break;
            case  2: value = 4.0/2.0; break;
            case  3: value = 5.0/2.0; break;
            case  4: value = 6.0/2.0; break;
            default: value = 1.0;
        }
        return value;
    }


    // Memberikan efek buff ke monster
    public static void buffMonster(Player p, StatusMove buffMove){
        System.out.println(p.getCurrentMonster().getNama() + " milik " + p.getName() + " mendapatkan buff!");
        // Buff Attack
        if (buffMove.getBuffAttack() != 0){
            double currAttack  = p.getCurrentMonster().getBaseStats().getAttack();
            double newAttack   = Math.floor(currAttack*buffFactor(buffMove.getBuffAttack()));
            p.getCurrentMonster().getBaseStats().setAttack(newAttack);
            if (newAttack > currAttack){
                System.out.println("Attack bertambah dari " + currAttack + " menjadi " + newAttack + "!");
            } else if (newAttack < currAttack){
                System.out.println("Attack berkurang dari " + currAttack + " menjadi " + newAttack + "!");
            }
        }
        // Buff Defense
        if (buffMove.getBuffDefense() != 0){
            double currDefense = p.getCurrentMonster().getBaseStats().getDefense();
            double newDefense  = Math.floor(currDefense*buffFactor(buffMove.getBuffDefense()));
            p.getCurrentMonster().getBaseStats().setDefense(newDefense);
            if (newDefense > currDefense){
                System.out.println("Defense bertambah dari " + currDefense + " menjadi " + newDefense + "!");
            } else if (newDefense < currDefense){
                System.out.println("Defense berkurang dari " + currDefense + " menjadi " + newDefense + "!");
            }
        }
        // Buff Special Attack
        if (buffMove.getBuffSpecialAttack() != 0){
            double currSpecialAttack = p.getCurrentMonster().getBaseStats().getSpecialAttack();
            double newSpecialAttack  = Math.floor(currSpecialAttack*buffFactor(buffMove.getBuffSpecialAttack()));
            p.getCurrentMonster().getBaseStats().setSpecialAttack(newSpecialAttack);
            if (newSpecialAttack > currSpecialAttack){
                System.out.println("Special Attack bertambah dari " + currSpecialAttack + " menjadi " + newSpecialAttack + "!");
            } else if (newSpecialAttack < currSpecialAttack){
                System.out.println("Special Attack berkurang dari " + currSpecialAttack + " menjadi " + newSpecialAttack + "!");
            }
        }
        // Buff Special Defense
        if (buffMove.getBuffSpecialDefense() != 0){
            double currSpecialDefense = p.getCurrentMonster().getBaseStats().getSpecialDefense();
            double newSpecialDefense  = Math.floor(currSpecialDefense*buffFactor(buffMove.getBuffSpecialDefense()));
            p.getCurrentMonster().getBaseStats().setSpecialDefense(newSpecialDefense);
            if (newSpecialDefense > currSpecialDefense){
                System.out.println("Special Defense bertambah dari " + currSpecialDefense + " menjadi " + newSpecialDefense + "!");
            } else if (newSpecialDefense < currSpecialDefense){
                System.out.println("Special Defense berkurang dari " + currSpecialDefense + " menjadi " + newSpecialDefense + "!");
            }
        }
        // Buff Speed
        if (buffMove.getBuffSpeed() != 0){
            double currSpeed = p.getCurrentMonster().getBaseStats().getSpeed();
            double newSpeed  = Math.floor(currSpeed*buffFactor(buffMove.getBuffSpeed()));
            p.getCurrentMonster().getBaseStats().setSpeed(newSpeed);
            if (newSpeed > currSpeed){
                System.out.println("Speed bertambah dari " + currSpeed + " menjadi " + newSpeed + "!");
            } else if (newSpeed < currSpeed){
                System.out.println("Speed berkurang dari " + currSpeed + " menjadi " + newSpeed + "!");
            }
        }
    }

}
