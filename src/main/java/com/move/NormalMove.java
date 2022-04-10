package com.move;

import com.monster.ElementType;

public class NormalMove extends Move {

    protected double basePower;
    protected int id;

    public NormalMove(int id, String moveName, ElementType elementType, int accuracy, int priority,
                      int ammunition, TargetOfMove targetOfMove, double basePower) {

        super(moveName, "NORMAL", elementType, accuracy, priority, ammunition, targetOfMove);
        this.id = id;
        this.basePower = basePower;

    }

    // Getter
    public double getBasePower() {
        return basePower;
    }

    public int getId() {
        return id;
    }

    // Setter
    public void setBasePower(double basePower) {
        this.basePower = basePower;
    }

    public void setId(int id) {
        this.id = id;
    }
    // buat method untuk dapetin nilai damage calculation
    /***
    public void normalMove(Monster originMons, Monster targetMons) {

        Random rand = new Random();
        int randomInt = rand.nextInt(100-85) + 85;
        double ranDouble = randomInt/100;
        double damage = Math.floor((basePower*(originMons.getBaseStats().getAttack()/targetMons.getBaseStats().getDefense())+2)*(ranDouble));// dikali effectivity// //burn//);
        double newHP = targetMons.getBaseStats().getHealthPoint() - damage;
        targetMons.getBaseStats().setHealthPoint(newHP);
    }
    ***/
}


