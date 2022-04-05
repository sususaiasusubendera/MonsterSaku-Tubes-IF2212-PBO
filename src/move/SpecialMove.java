package src.move;

import com.monster.Monster;
import com.monstersaku.Stats;

public class SpecialMove extends Move {

    private double basePower;

    public SpecialMove(int id, String moveType, String name, ElementType elementType, int accuracy,
                       int priority, int ammunition, int basePower) {
        super(id, moveType, name, elementType, accuracy, priority, ammunition);
        this.basePower = basePower;
    }

    public double getBasePower() {

        return basePower;
    }

    public void specialMove(Monster originMons, Monster targetMons) {

        basePower = originMons.getBaseStats().getSpecialAttack() - targetMons.getBaseStats().getSpecialDefense();
        double newHP = targetMons.getHealthPoint() - basePower;
        originMons.getBaseStats().setHealthPoint(newHP);
    }



}
