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
                String playerName1 = scanner.next();
                System.out.printf("2: ");
                String playerName2 = scanner.next();
                // buat players
                Player p1 = new Player(playerName1);
                Player p2 = new Player(playerName2);

                while (!p1.isAllDead() && !p2.isAllDead()) { // while player 1 dan 2 monsternya masi blm mati semua 
                    // turn player 1
                    System.out.println("Giliran: " + p1.getName());
                    System.out.println("Pilih menu!");
                    System.out.printf("[1] Move\n[2] Switch\n[3] Help\n[4] Exit\n[5] View Monster Info\n[6] View Game Info"); // tambahin menu aplikasi (help, exit, dll), mungkin buat printMenu di mainmenu
                    int pilihan = scanner.nextInt();
                    Move move1 = new DefaultMove();
                    if (pilihan == 1) {
                        // print list of moves yg dipunyai monster
                        move1 = SelectionMenu.chooseMove(p1);
                    } else if (pilihan == 2) {
                        SelectionMenu.chooseMonster(p1);
                    } else if (pilihan == 3) {
                        MainMenu.help();
                    } else if (pilihan == 4) {
                        MainMenu.exit();
                    } else if (pilihan == 5) {
                        // buat view monster info, bisa di main menu?
                    } else if (pilihan == 6) {
                        // buat view game info (ntahlah bisa di main menu atau di sini ae)
                    }

                    // turn player 2
                    System.out.println("Giliran: " + p2.getName());
                    System.out.println("Pilih menu!");
                    System.out.printf("[1] Move\n[2] Switch\n");
                    int pilihan2 = scanner.nextInt();
                    Move move2 = new DefaultMove();
                    if (pilihan2 == 1) {
                        move2 = SelectionMenu.chooseMove(p2);
                    } else if (pilihan2 == 2) {
                        SelectionMenu.chooseMonster(p2);
                    }

                    // compare move
                    if (pilihan == 1 && pilihan2 == 1) {
                        if (move1.getPriority() > move2.getPriority()) {
                            /*** ini ada di selectionMenu
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
                            // SIMPLIFIED
                            SelectionMenu.useMove(p1, p2, move1);
                            if (p2.getCurrentMonster().getBaseStats().getHealthPoint() <= 0) {
                                System.out.println("Yah, monster kamu mati :( ganti yak");
                                SelectionMenu.chooseMonster(p2);
                            } else {
                                SelectionMenu.useMove(p2, p1, move2);
                                if (p1.getCurrentMonster().getBaseStats().getHealthPoint() <= 0) {
                                    System.out.println("Yah, monster kamu mati :( ganti yak");
                                    SelectionMenu.chooseMonster(p1);
                                }
                            }
                            ***/
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
                        
                    } else if (pilihan == 1 && pilihan2 == 2) {
                        // use move 1
                        SelectionMenu.useMove(p1, p2, move1);
                    } else if (pilihan == 2 && pilihan2 == 1) {
                        // use move 2
                        SelectionMenu.useMove(p2, p1, move2);
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