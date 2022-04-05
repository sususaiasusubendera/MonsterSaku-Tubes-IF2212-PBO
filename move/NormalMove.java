package move;

import com.monster.Monster;

public class NormalMove extends Move {

    private double basePower;

    public NormalMove(int id, String moveType, String name, ElementType elementType, int accuracy, int priority,
                      int ammunition, double basePower) {

        super(id, moveType, name, elementType, accuracy, priority, ammunition);
        this.basePower = basePower;

    }

    public double getBasePower() {

        return basePower;
    }

    // buat method untuk dapetin nilai damage

    public void normalMove(Monster originMons, Monster targetMons) {

        basePower = originMons.getBaseStats().getAttack() - targetMons.getBaseStats().getDefense();
        double newHP = target.getBaseStats().getHealthPoint() - basePower;
        targetMons.getBaseStats().setHealthPoint(newHP);
    }
}


