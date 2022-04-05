package com.monstersaku;

import java.lang.System;
import java.util.Scanner;

// ini blm lengkap si,, kynya bisa ditambah new player atau new game gitu ntar

public class MainMenu {
    public static void main(String[] args) {
        System.out.println("Welcome to Monster Saku!");
        System.out.println("Siapa aja yang main?");
        Scanner scanner = new Scanner(System.in);
        System.out.printf("1: " );
        String playerName1 = scanner.next(); // butuh gasih player name? .-.
        System.out.printf("2: ");
        String playerName2 = scanner.next();
        while (true) {
            System.out.println("Pilih menu: ");
            System.out.println("[1] Start Game\n[2] Help\n[3] Exit");
            int pick = scanner.nextInt();
            if (pick == 1) {
                System.out.println("Mulai game");
                /***
                gimana nih mulai gamenya(?)
                Game game = new Game();
                game.startGame();
                ***/
            } else if (pick == 2) {
                MainMenu.help();
            } else if (pick == 3) {
                MainMenu.exit();
            }
        }
    }

    // method (kalo jadi gini bisa dipake dalem game ga ya? atau dibuat interface aja menunya?)
    public static void help() {
        System.out.println("Monster Saku adalah sebuah game berbasis CLI.");
        System.out.println("Cara bermain: ");
        System.out.println("1. Ada 2 pemain dalam game yang akan diberikan 6 monster di awal permainan");
        System.out.println("2. Kedua pemain akan masuk ke dalam fase pertarungan");
        System.out.println("3. Dalam fase pertarungan, kedua pemain secara bergilir memilih move");
        System.out.println("4. Move akan dieksekusi bergiliran berdasarkan prioritas dan speed");
        System.out.println("5. Pemain dengan monster setidaknya satu di akhir permainan akan menang");
    }

    public static void exit() {
        System.out.println("Bye!");
        System.exit(0);
    }

}
