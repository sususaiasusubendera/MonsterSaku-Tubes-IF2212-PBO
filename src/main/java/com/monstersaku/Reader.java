package com.monstersaku;
// KAYANYAAA ntar main menu mau dipindah ke sini
import com.move.*;
import com.monster.*;

import com.monstersaku.util.CSVReader;

import java.io.File;
import java.lang.annotation.ElementType;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.lang.model.element.Element;

import java.util.ArrayList;

public class Reader {
    private static final List<String> CSV_FILE_PATHS = Collections.unmodifiableList(Arrays.asList(
            "configs/monsterpool.csv",
            "configs/movepool.csv",
            "configs/element-type-effectivity-chart.csv"));
/***
    public static void main(String[] args) {
        for (String fileName : CSV_FILE_PATHS) {
            try {
                System.out.printf("Filename: %s\n", fileName);
                CSVReader reader = new CSVReader(new File(Main.class.getResource(fileName).toURI()), ";");
                reader.setSkipHeader(true);
                List<String[]> lines = reader.read();
                System.out.println("=========== CONTENT START ===========");
                for (String[] line : lines) {
                    for (String word : line) {
                        System.out.printf("%s ", word);
                    }
                    System.out.println();
                }
                System.out.println("=========== CONTENT END ===========");
                System.out.println();
            } catch (Exception e) {
                // do nothing
            }
        }
    }
***/
    
        public static List<Monster> listMonster = new ArrayList<Monster>();
        public static List<Move> listMove = new ArrayList<Move>();
        // baca movepool.csv
        try {
            CSVReader reader = new CSVReader(new File(Main.class.getResource("configs/movepool.csv").toURI()), ";");
            reader.setSkipHeader(true);
            List<String[]> lines = reader.read();
            for (String[] line : lines) {
                // id
                Integer id = Integer.parseInt(line[0]);
                // moveType 
                String mvType = line[1];
                // move name
                String mvName = line[2];
                // element type
                com.monster.ElementType elType = com.monster.ElementType.valueOf(line[3]);
                // accuracy
                Integer accuracy = Integer.parseInt(line[4]);
                // priority
                Integer priority = Integer.parseInt(line[5]);
                // ammunition
                Integer ammunition = Integer.parseInt(line[6]);
                // target
                TargetOfMove tOfMove = TargetOfMove.valueOf(line[7]);
                // effect (non status vs status move)
                if (mvType.equals("STATUS")) {
                    // bentuk object status move
                    String effect = line[8];
                    String statsEffect = line[9];
                    String[] arrStatsEffect = statsEffect.split(",", 10);
                    Double healHP = Double.parseDouble(arrStatsEffect[0]);
                    StatusMove move = new StatusMove(id, mvName, elType, accuracy, priority, ammunition, effect, healHP);
                    // tambahkan ke list moves
                    listMove.add(move);
                } else {
                    // bentuk object move jenis selain status move
                    Double basePower = Double.parseDouble(line[8]);
                    if (mvType.equals("NORMAL")) {
                        Move move = new Move(id, mvName, mvType, elType, accuracy, priority, ammunition);
                    }
                    
                    // tambahkan ke list moves
                    listMove.add(move);
                }               
                // karna ga ngerjain bonus, status move cuma ngasih dampak ke status condition dan heal HP
            }
        // baca monsterpool.csv
            CSVReader reader2 = new CSVReader(new File(Main.class.getResource("configs/monsterpool.csv").toURI()), ";");
            reader2.setSkipHeader(true);
            List<String[]> lines2 = reader2.read();
            for (String[] line : lines2) {
                // id
                Integer id = Integer.parseInt(line[0]);
                
                // name
                String name = line[1];

                // elementTypes
                String elType = line[2];
                String[] arrET = elType.split(",", 10);
                List<com.monster.ElementType> elTypes = new ArrayList<com.monster.ElementType>();
                for (String et : arrET) {
                    com.monster.ElementType x = com.monster.ElementType.valueOf(et);
                    elTypes.add(x);
                }
                
                // baseStats
                String stat = line[3];
                String[] arrStats = stat.split(",", 10);
                List<Double> theStats = new ArrayList<Double>();
                for (String stats : arrStats) {
                    Double x = Double.parseDouble(stats);
                    theStats.add(x);
                }
                Stats baseStats = new Stats(theStats.get(0), theStats.get(1),theStats.get(2),theStats.get(3),theStats.get(4),theStats.get(5));
                
                // moves
                String move = line[4];
                String[] arrMoves = move.split(",", 10);
                List<Move> theMoves = new ArrayList<Move>();
                for (int i = 0; i < arrMoves.length; i ++) {
                    theMoves.add(listMove.get(Integer.valueOf(arrMoves[i])-1));
                }

                // buat object monster
                Monster monster = new Monster(id, name, elTypes, baseStats, theMoves);
                listMonster.add(monster);
            }
            // baca element type effectivity
            // enaknya dibuat apa ya? hash map?
            HashMap<String, Double> listEffectivity = new HashMap<String, Double>();
            CSVReader reader3 = new CSVReader(new File(Main.class.getResource("configs/element-type-effectivity-chart.csv").toURI()), ";");
            reader3.setSkipHeader(true);
            List<String[]> lines3 = reader3.read();
            for (String[] line : lines3) {
                // source
                ElementType source = ElementType.valueOf(line[0]);
                // target
                ElementType target = ElementType.valueOf(line[1]);
                // effectivity
                Double effectivity = Double.parseDouble(line[2]);
                // add ke hash map
                String snt = source.name()+target.name();
                listEffectivity.put(snt, effectivity);
            }
        } catch (Exception e) {
            //apaya
        }
    
}
