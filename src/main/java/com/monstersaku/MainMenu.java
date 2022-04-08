package com.monstersaku;

import java.lang.System;
import java.util.Scanner;

// ini blm lengkap si,, kynya bisa ditambah new player atau new game gitu ntar

public class MainMenu {
    

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
