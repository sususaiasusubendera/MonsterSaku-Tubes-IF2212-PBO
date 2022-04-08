package com.game;

import java.util.*;
import com.monstersaku.*;
import com.move.*;

public class GameFlow {

    public static void main(String[] args) {
        System.out.println("Welcome to Monster Saku!");
        
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("Pilih menu: ");
            System.out.println("[1] Start Game\n[2] Help\n[3] Exit");
            int pick = scanner.nextInt();
            if (pick == 1) {
                System.out.println("Mulai game");
                System.out.println("Siapa aja yang main?");
                System.out.printf("1: " );
                String playerName1 = scanner.next(); // butuh gasih player name? .-.
                System.out.printf("2: ");
                String playerName2 = scanner.next();
                // buat players
                Player p1 = new Player(playerName1, listOfMonster1);
                Player p2 = new Player(playerName2, listOfMonster2);

                while (!p1.isAllDead() && !p2.isAllDead()) { // while player 1 dan 2 monsternya masi blm mati semua 
                    // turn player 1
                    System.out.println("Giliran: " + p1.getName());
                    System.out.println("Pilih menu!");
                    System.out.printf("[1] Move\n[2] Switch\n"); // tambahin menu aplikasi (help, exit, dll), mungkin buat printMenu di mainmenu
                    int pilihan = scanner.nextInt();
                    Move move1 = new DefaultMove();
                    if (pilihan == 1) {
                        // print list of moves yg dipunyai monster
                        System.out.println("Pilih move: ");
                        p1.getCurrentMonster().printMoves();
                        int movePick1 = scanner.nextInt();
                        move1 = p1.getCurrentMonster().getMoves().get(movePick1-1);
                    } else if (pilihan == 2) {
                        
                        System.out.println("Pilih monster: ");
                        p1.printMonsters();
                        int monsPick1 = scanner.nextInt();
                        p1.setCurrentMonster(p1.getListOfMonster().get(monsPick1-1));
                    }

                    // turn player 2
                    System.out.println("Giliran: " + p2.getName());
                    System.out.println("Pilih menu!");
                    System.out.printf("[1] Move\n[2] Switch\n");
                    int pilihan2 = scanner.nextInt();
                    Move move2 = new DefaultMove();
                    if (pilihan2 == 1) {
                        // print list of moves yg dipunyai monster
                        System.out.println("Pilih move: ");
                        p2.getCurrentMonster().printMoves();
                        System.out.println("[0] Default Move");
                        int movePick2 = scanner.nextInt();
                        if (movePick2 != 0) {
                            move2 = p2.getCurrentMonster().getMoves().get(movePick2-1);
                        } else {
                            move2 = new DefaultMove();
                        }
                    } else if (pilihan2 == 2) {
                        // kayanya ini dibikin method aja
                        System.out.println("Pilih monster: ");
                        p2.printMonsters();
                        int monsPick2 = scanner.nextInt();
                        p2.setCurrentMonster(p2.getListOfMonster().get(monsPick2-1));
                    }

                    // compare move
                    if (pilihan == 1 && pilihan2 == 1) {
                        if (move1.getPriority() > move2.getPriority()) {
                            if (new Random().nextDouble() <= (move1.getAccuracy()/100)) {
                                if(move1.getTarget() == TargetOfMove.OWN) {
                                    if (move1 instanceof StatusMove) {
                                        StatusMove statusMove = (StatusMove)move1;
                                        p1.getCurrentMonster().getBaseStats().setHealthPoint(statusMove.getHealHP());
                                    }
                                } else if (move1.getTarget() == TargetOfMove.ENEMY) {
                                    if (move1 instanceof NormalMove) {
                                        NormalMove normalMove = (NormalMove)move1;
                                        // damage calculation menyusulll
                                    } else if (move1 instanceof SpecialMove) {
                                        SpecialMove specialMove = (SpecialMove)move1;
                                        // damage calcu mnyusul
                                    } else if (move1 instanceof DefaultMove) {
                                        //aaaaaaaaaaaaaaaaaaaaaa
                                    }
                                } // dibuat sesuatu semacam useMove????
                            } else {
                                System.out.println("Player " + p1.getName() + "gagal melakukan move");
                            }
                        } else if (move1.getPriority() < move2.getPriority()) {
                            // copas,, hehe (useMove p2 duluan)
                        } else if (move1.getPriority() == move2.getPriority()) {
                            if (p1.getCurrentMonster().getBaseStats().getSpeed() < p2.getCurrentMonster().getBaseStats().getSpeed()) {
                                // usemove (p2 duluan)
                                // getCurrentMonster bisa dijadiin variabel
                            } else if (p1.getCurrentMonster().getBaseStats().getSpeed() > p2.getCurrentMonster().getBaseStats().getSpeed()) {
                                // usemove (p1 duluan)
                            } else if (p1.getCurrentMonster().getBaseStats().getSpeed() == p2.getCurrentMonster().getBaseStats().getSpeed()) {
                                // ngerandom 1 atau 2
                                if (new Random().nextInt(2) == 0) {
                                    // use move 1 duluan
                                } else {
                                    // use move 2 duluan
                                }
                            }
                        }
                        // use move (siapapun yg blm)
                    } else if (pilihan == 1 && pilihan2 == 2) {
                        // use move 1
                    } else if (pilihan == 2 && pilihan2 == 1) {
                        // use move 2
                    }
                    
                }
                
                

                
            } else if (pick == 2) {
                MainMenu.help();
            } else if (pick == 3) {
                MainMenu.exit();
            }
        }

    }
}
