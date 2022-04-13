package com.monstersaku;

// TADINYA INI GameFlow.java

import com.game.*;
import com.player.*;
import com.reader.Reader;
import com.condition.*;
import com.move.Move;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MonsterSaku {

    public static void main(String[] args) {
        Reader.setGameMoves();
        Reader.setGameMonsters();
        Reader.setGameMapEffectivity();
        if (Reader.getGameMoves().isEmpty() || Reader.getGameMonsters().isEmpty() || Reader.getGameMapEffectivity().isEmpty()){
            System.exit(0);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("");
        System.out.println("░█▄█░█▀█░█▀█░█▀▀░▀█▀░█▀▀░█▀▄░░░█▀▀░█▀█░█░█░█░█░");
        System.out.println("░█░█░█░█░█░█░▀▀█░░█░░█▀▀░█▀▄░░░▀▀█░█▀█░█▀▄░█░█░");
        System.out.println("░▀░▀░▀▀▀░▀░▀░▀▀▀░░▀░░▀▀▀░▀░▀░░░▀▀▀░▀░▀░▀░▀░▀▀▀░");
        System.out.println("");
        System.out.println("----------- Press Enter to Continue -----------");
        try{scanner.nextLine();} catch(Exception e) {}
        
        while (true) {
            int pick = 0;
            do {
                try {
                    System.out.println("Pilih menu: ");
                    System.out.println("[1] Start Game\n[2] Help\n[3] Exit");
                    System.out.printf("Pilihanku: ");
                    pick = scanner.nextInt();
                    System.out.println("");
                    if (pick < 1 || pick > 3){
                        System.out.println("--- Masukan salah, tolong diulang ya ---");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("");
                    System.out.println("--- Masukan salah, tolong diulang ya ---");
                    scanner.next();
                    continue;
                }
            } while (pick < 1 || pick > 3);
            if (pick == 1) {
                System.out.println("======================= GAME STARTED =======================");
                System.out.println("Siapa aja yang main?");
                System.out.printf("1: " );
                String playerName1 = scanner.next();
                System.out.printf("2: ");
                String playerName2 = scanner.next();
                System.out.println("");
                // buat players
                Player p1 = new Player(playerName1);
                Player p2 = new Player(playerName2);
                System.out.println("");
                int ronde = 0;

                while (!p1.isAllDead() && !p2.isAllDead()) { // while player 1 dan 2 monsternya masi blm mati semua 
                    ronde += 1;
                    SelectionMenu.decrementSleepCount(p1);
                    SelectionMenu.decrementSleepCount(p2);

                    System.out.printf("========================= Ronde %s =========================\n", String.format("%02d", ronde));
                    
                    // turn player 1
                    int pilihan = 0;
                    do {
                        try {
                            System.out.println("Giliran   : " + p1.getName());
                            System.out.println("Monstermu : " + p1.getCurrentMonster().getNama());
                            System.out.println("Current HP: " + p1.getCurrentMonster().getBaseStats().getHealthPoint());
                            System.out.println("Pilih menu!");
                            System.out.println("[1] Move\n[2] Switch\n[3] Help\n[4] Exit\n[5] View Monsters Info\n[6] View Game Info"); // tambahin menu aplikasi (help, exit, dll), mungkin buat printMenu di mainmenu
                            System.out.printf("Pilihanku: ");
                            pilihan = scanner.nextInt();
                            System.out.println("");
                            if (pilihan == 3) {
                                MainMenu.help();
                            } else if (pilihan == 4) {
                                scanner.close();
                                MainMenu.exit();
                            } else if (pilihan == 5) {
                                MainMenu.viewMonsterInfo(p1, scanner);
                            } else if (pilihan == 6) {
                                MainMenu.viewGameInfo(p1, ronde);
                            } else if (pilihan > 6 || pilihan < 1){
                                System.out.println("--- Masukan salah, tolong diulang ya ---");
                            }
                        } catch (InputMismatchException e){
                            System.out.println("");
                            System.out.println("--- Masukan salah, tolong diulang ya ---");
                            scanner.next();
                            continue;
                        }
                    } while (pilihan != 1 && pilihan != 2);
                    Move move1 = null;
                    if (pilihan == 1) {
                        if (p1.getCurrentMonster().getCondi().getStatCondi() == StatusCondition.SLEEP) {
                            if (p1.isAllSleep()) {
                                System.out.println("Maaf, monster kamu kena SLEEP semua");
                                System.out.println("Tidak bisa bergerak!");
                            } else {
                                while (p1.getCurrentMonster().getCondi().getSleepCount() > 0) {
                                    System.out.println("Maaf, monster yang kamu pakai lagi kena SLEEP!");
                                    System.out.println("Sisa SLEEP: " + p1.getCurrentMonster().getCondi().getSleepCount() + " ronde lagi");
                                    System.out.println("Ganti monster, yuk!");
                                    SelectionMenu.chooseMonster(p1);
                                }
                                move1 = SelectionMenu.chooseMove(p1);
                            }
                        } else if (p1.getCurrentMonster().getCondi().getStatCondi() == StatusCondition.PARALYZE) {
                            if (p1.getCurrentMonster().getCondi().getCanMove()) {
                                move1 = SelectionMenu.chooseMove(p1);
                            } else {
                                p1.getCurrentMonster().getCondi().setCanMove(true);
                                System.out.println("Monster yang kamu pakai lagi kena PARALYZE");
                                System.out.println("Sayangnya kamu jadi tidak bisa bergerak");
                            }
                        } else {
                            move1 = SelectionMenu.chooseMove(p1);
                        }
                    } else if (pilihan == 2) {
                        SelectionMenu.chooseMonster(p1);
                    }


                    // turn player 2
                    int pilihan2 = 0;
                    do {
                        try {
                            System.out.println("Giliran   : " + p2.getName());
                            System.out.println("Monstermu : " + p2.getCurrentMonster().getNama());
                            System.out.println("Current HP: " + p2.getCurrentMonster().getBaseStats().getHealthPoint());
                            System.out.println("Pilih menu!");
                            System.out.println("[1] Move\n[2] Switch\n[3] Help\n[4] Exit\n[5] View Monsters Info\n[6] View Game Info"); // tambahin menu aplikasi (help, exit, dll), mungkin buat printMenu di mainmenu
                            System.out.printf("Pilihanku: ");
                            pilihan2 = scanner.nextInt();
                            System.out.println("");
                            if (pilihan2 == 3) {
                                MainMenu.help();
                            } else if (pilihan2 == 4) {
                                scanner.close();
                                MainMenu.exit();
                            } else if (pilihan2 == 5) {
                                MainMenu.viewMonsterInfo(p2, scanner);
                            } else if (pilihan2 == 6) {
                                MainMenu.viewGameInfo(p2, ronde);
                            } else if (pilihan2 > 6 || pilihan2 < 1){
                                System.out.println("--- Masukan salah, tolong diulang ya ---");
                            }
                        } catch (InputMismatchException e){
                            System.out.println("");
                            System.out.println("--- Masukan salah, tolong diulang ya ---");
                            scanner.next();
                            continue;
                        }
                    } while (pilihan2 != 1 && pilihan2 != 2);
                    Move move2 = null;
                    if (pilihan2 == 1) {
                        if (p2.getCurrentMonster().getCondi().getStatCondi() == StatusCondition.SLEEP) {
                            if (p2.isAllSleep()) {
                                System.out.println("Maaf, monster kamu kena SLEEP semua");
                                System.out.println("Tidak bisa bergerak!");
                            } else {
                                while (p2.getCurrentMonster().getCondi().getSleepCount() > 0) {
                                    System.out.println("Maaf, monster yang kamu pakai lagi kena SLEEP!");
                                    System.out.println("Sisa SLEEP: " + p2.getCurrentMonster().getCondi().getSleepCount() + " ronde lagi");
                                    System.out.println("Ganti monster, yuk!");
                                    SelectionMenu.chooseMonster(p2);
                                }
                                move2 = SelectionMenu.chooseMove(p2);
                            }
                        } else if (p2.getCurrentMonster().getCondi().getStatCondi() == StatusCondition.PARALYZE) {
                            if (p2.getCurrentMonster().getCondi().getCanMove()) {
                                move2 = SelectionMenu.chooseMove(p2);
                            } else {
                                p2.getCurrentMonster().getCondi().setCanMove(true);
                                System.out.println("Monster yang kamu pakai lagi kena PARALYZE");
                                System.out.println("Sayangnya kamu jadi tidak bisa bergerak");
                            }
                        } else {
                            move2 = SelectionMenu.chooseMove(p2);
                        }
                    } else if (pilihan2 == 2) {
                        SelectionMenu.chooseMonster(p2);
                    }


                    // compare move
                    if (pilihan == 1 && pilihan2 == 1) {
                        if (move1 != null && move2 != null) {
                            if (move1.getPriority() > move2.getPriority()) {
                                // p1 move duluan
                                SelectionMenu.battle(p1, p2, move1, move2);
                            } else if (move1.getPriority() < move2.getPriority()) {
                                // p2 move duluan
                                SelectionMenu.battle(p2, p1, move2, move1);
                            } else if (move1.getPriority() == move2.getPriority()) {
                                if (p1.getCurrentMonster().getBaseStats().getSpeed() > p2.getCurrentMonster().getBaseStats().getSpeed()) {
                                    // p1 move duluan
                                    SelectionMenu.battle(p1, p2, move1, move2);
                                } else if (p1.getCurrentMonster().getBaseStats().getSpeed() < p2.getCurrentMonster().getBaseStats().getSpeed()) {
                                    // p2 move duluan
                                    SelectionMenu.battle(p2, p1, move2, move1);
                                } else if (p1.getCurrentMonster().getBaseStats().getSpeed() == p2.getCurrentMonster().getBaseStats().getSpeed()) {
                                    // ngerandom 1 atau 2
                                    if (new Random().nextInt(2) == 0) {
                                        // p1 move duluan
                                        SelectionMenu.battle(p1, p2, move1, move2);
                                    } else {
                                        // p2 move duluan
                                        SelectionMenu.battle(p2, p1, move2, move1);
                                    }
                                }
                            }
                        } else if (move1 != null && move2 == null) {
                            // use move1
                            SelectionMenu.useMove(p1, p2, move1);
                            // jika monster p2 mati setelah p1 melakukan move
                            if (p2.getCurrentMonster().getBaseStats().getHealthPoint() <= 0){
                                p2.removeCurrMonster();
                            }
                        } else if (move1 == null && move2 != null) {
                            // use move2
                            SelectionMenu.useMove(p2, p1, move2);
                            // jika monster p1 mati setelah p2 melakukan move
                            if (p1.getCurrentMonster().getBaseStats().getHealthPoint() <= 0){
                                p1.removeCurrMonster();
                            }
                        } else if (move1 == null && move2 == null) {
                            System.out.println("WKWK gabisa move kalian");
                        }
                    } else if (pilihan == 1 && pilihan2 == 2) {
                        // use move1 (p1 melakukan move)
                        SelectionMenu.useMove(p1, p2, move1);
                        // jika monster p2 mati setelah p1 melakukan move
                        if (p2.getCurrentMonster().getBaseStats().getHealthPoint() <= 0){
                            p2.removeCurrMonster();
                        }
                    } else if (pilihan == 2 && pilihan2 == 1) {
                        // use move2 (p2 melakukan move)
                        SelectionMenu.useMove(p2, p1, move2);
                        // jika monster p1 mati setelah p2 melakukan move
                        if (p1.getCurrentMonster().getBaseStats().getHealthPoint() <= 0){
                            p1.removeCurrMonster();
                        }
                    } else if (pilihan == 2 && pilihan2 == 2){
                        System.out.println("Kalian berdua memilih SWITCH");
                        System.out.println("Lanjut ke ronde berikutnya!");
                    }
                    DamageCalculation.afterDamage(p1);
                    // jika monster p1 mati karena afterdamage
                    if (p1.getCurrentMonster().getBaseStats().getHealthPoint() <= 0){
                        p1.removeCurrMonster();
                    }
                    DamageCalculation.afterDamage(p2);
                    // jika monster p2 mati karena afterdamage
                    if (p2.getCurrentMonster().getBaseStats().getHealthPoint() <= 0){
                        p2.removeCurrMonster();
                    }
                    System.out.printf("====================== Akhir Ronde %s ======================\n\n\n", String.format("%02d", ronde));
                }
                System.out.println("------------------ GAME OVER ------------------");
                // cek pemenang
                if (!p1.isAllDead() && p2.isAllDead()) {
                    System.out.println("SELAMAT! " + p1.getName() + " adalah pemenangnya");
                } else if (!p2.isAllDead() && p1.isAllDead()) {
                    System.out.println("SELAMAT! " + p2.getName() + " adalah pemenangnya");
                } else if (p1.isAllDead() && p2.isAllDead()){
                    System.out.println("Sayang sekali, tidak ada pemenang kali ini");
                }
                System.out.println("============================================================");
            } else if (pick == 2) {
                MainMenu.help();
            } else if (pick == 3) {
                scanner.close();
                MainMenu.exit();
            }
        }
        
    }
}

// YANG KURANG
/***
 * benerin statuscondition
 * implementasi statuscondition (kalo movenya jenis statusmove)
 * ^ itu kayanya harus benerin useMove, tp emang useMove masi ngaco sih
 * benerin move (default move, trs yg lain biar ngikutin csv (?))
 * benerin csv reader biar sesuai move
 * damage calculation...
 * after damage calculation
 * view monster info
 * view game info
 * BOOKLET...
 * sama apa lg ya sorry klo ada yg kelewat atau codenya gaje
 * 
 */