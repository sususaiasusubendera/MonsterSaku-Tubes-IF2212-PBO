package com.game;

import java.lang.System;
import java.util.*;

import com.player.*;
import com.reader.Reader;
import com.monster.*;


public class MainMenu {
    
    public static void help() {
        System.out.println("------------------------------------ HELP ------------------------------------");
        System.out.println("Monster Saku adalah sebuah game berbasis CLI.");
        System.out.println("Cara bermain: ");
        System.out.println("1. Ada 2 pemain dalam game yang akan diberikan 6 monster di awal permainan");
        System.out.println("2. Kedua pemain akan masuk ke dalam fase pertarungan");
        System.out.println("3. Dalam fase pertarungan, kedua pemain secara bergilir memilih move");
        System.out.println("4. Move akan dieksekusi bergiliran berdasarkan prioritas dan speed");
        System.out.println("5. Pemain dengan monster setidaknya satu di akhir permainan akan menang");
        System.out.println("------------------------------------------------------------------------------\n");
    }

    public static void exit() {
        try {
            System.out.println("  _            /|       _________   ");
            System.out.println("  \\`.         /_|      /         \\  ");
            System.out.println("   \\-\\        | |     /  See you  \\ ");
            System.out.println("    \\ \\ ______| |     \\  later!   / ");
            System.out.println("     \\.``    `` |      \\ ________/  ");
            System.out.println("     /          \\      //           ");
            System.out.println("    |  @   .  @  | .--.             ");
            System.out.println("    | _   ___  _ |/   /             ");
            System.out.println("    \\(_)  \\_/ (_)/   /_________     ");
            System.out.println(" ____`._      _,/   / \\        |    ");
            System.out.println("/                  /   \\    ___|    ");
            System.out.println("`-----._          |  ___\\  |        ");
            System.out.println("      |            \\ \\   __|        ");
            System.out.println("     /              \\_\\ \\           ");
            System.out.println("     |              |____\\          ");
            System.out.println("     \\              /               ");
            System.out.println("   __.`--.-------.-''___             ");
            System.out.println("  '-----`         `----`            ");
            int timer = 4;
            System.out.printf("Exiting game.");
            for (int i = 0;i < timer;i++){
                Thread.sleep(1000);
                System.out.printf(".");
            }
            System.exit(0);
        } catch (InterruptedException e) {}
    }

    public static void viewMonsterInfo(Player p, Scanner scanner) {
        int pilihan = -1;
        System.out.println("---------------------------- MONSTERS INFO ----------------------------");
        do {
            try {
                for (int i = 1; i <= p.getNumberOfMonster(); i++) {
                    Monster currMonster = p.getListOfMonster().get(i-1);
                    System.out.printf("[%d] %s\n", i, currMonster.getNama());           
                }
                System.out.println("Pilih monster untuk melihat detailnya");
                System.out.println("Untuk melihat detail semua monster, pilih 0");
                System.out.printf("Pilihanku: ");
                pilihan = scanner.nextInt();
                System.out.println("");
                if (pilihan < 0 || pilihan > p.getNumberOfMonster()){
                    System.out.println("--- Masukan salah, tolong diulang ya ---");
                } else if (pilihan == 0){
                    for (int i = 1; i <= p.getNumberOfMonster(); i++){
                        Monster m = p.getListOfMonster().get(i-1);
                        Monster baseMonster = null;
                        for (Monster mons : Reader.getGameMonsters()) {
                            if (m.getId() == mons.getId()){
                                baseMonster = mons;
                            }
                        }
                        System.out.printf("[Monster ke-%d]\n", i);
                        System.out.printf("Nama            : %s\n", m.getNama());
                        System.out.printf("Id              : %d\n", m.getId());
                        System.out.printf("ElementType     : %s\n", m.getElementTypes().toString());
                        System.out.printf("HP              : %.1f/%.1f\n", m.getBaseStats().getHealthPoint(), m.getMaxHP());
                        System.out.printf("Attack          : %.1f/%.1f\n", m.getBaseStats().getAttack(), baseMonster.getBaseStats().getAttack());
                        System.out.printf("Defense         : %.1f/%.1f\n", m.getBaseStats().getDefense(), baseMonster.getBaseStats().getDefense());
                        System.out.printf("Special Attack  : %.1f/%.1f\n", m.getBaseStats().getSpecialAttack(), baseMonster.getBaseStats().getSpecialAttack());
                        System.out.printf("Special Defense : %.1f/%.1f\n", m.getBaseStats().getSpecialDefense(), baseMonster.getBaseStats().getSpecialDefense());
                        System.out.printf("Speed           : %.1f/%.1f\n", m.getBaseStats().getSpeed(), baseMonster.getBaseStats().getSpeed());
                        if (i != p.getNumberOfMonster()){
                            System.out.println("");
                        }
                    }
                } else if (pilihan >= 1 && pilihan <= p.getNumberOfMonster()){
                    Monster m = p.getListOfMonster().get(pilihan-1);
                    Monster baseMonster = null;
                    for (Monster mons : Reader.getGameMonsters()) {
                        if (m.getId() == mons.getId()){
                            baseMonster = mons;
                        }
                    }
                    System.out.printf("Nama            : %s\n", m.getNama());
                    System.out.printf("Id              : %d\n", m.getId());
                    System.out.printf("ElementType     : %s\n", m.getElementTypes().toString());
                    System.out.printf("HP              : %.1f/%.1f\n", m.getBaseStats().getHealthPoint(), m.getMaxHP());
                    System.out.printf("Attack          : %.1f/%.1f\n", m.getBaseStats().getAttack(), baseMonster.getBaseStats().getAttack());
                    System.out.printf("Defense         : %.1f/%.1f\n", m.getBaseStats().getDefense(), baseMonster.getBaseStats().getDefense());
                    System.out.printf("Special Attack  : %.1f/%.1f\n", m.getBaseStats().getSpecialAttack(), baseMonster.getBaseStats().getSpecialAttack());
                    System.out.printf("Special Defense : %.1f/%.1f\n", m.getBaseStats().getSpecialDefense(), baseMonster.getBaseStats().getSpecialDefense());
                    System.out.printf("Speed           : %.1f/%.1f\n", m.getBaseStats().getSpeed(), baseMonster.getBaseStats().getSpeed());
                }
            } catch (InputMismatchException e) {
                System.out.println("");
                System.out.println("--- Masukan salah, tolong diulang ya ---");
                scanner.next();
                continue;
            }
        } while (pilihan < 0 || pilihan > p.getNumberOfMonster());
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("");
    }

    public static void viewGameInfo(Player p, int ronde){
        System.out.println("--------------------- GAME INFO ---------------------");
        System.out.println("Ronde                : "+ ronde);
        System.out.println("Giliran              : " + p.getName());
        System.out.println("Monster yang bermain : " + p.getCurrentMonster().getNama());
        System.out.println("Monster yang tidak bermain :");
        List<Monster> Mons = new ArrayList<Monster>();
        for (Monster m: p.getListOfMonster()) {
            if (m != p.getCurrentMonster()) {
                Mons.add(m);
            }
        }
        if (Mons.isEmpty()){
            System.out.println("[Monster selain yang digunakan sudah mati semua]");
        } else{
            for (int i = 0; i < p.getNumberOfMonster() - 1; i++) {
                System.out.printf("[%d] %s\n", i + 1, Mons.get(i).getNama());
            }
        }
        System.out.println("-----------------------------------------------------");
        System.out.println("");
    }
}
