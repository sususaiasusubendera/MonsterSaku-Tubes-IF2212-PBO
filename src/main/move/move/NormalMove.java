package move;

import java.lang.annotation.ElementType;

public class NormalMove extends Move {

    private double basePower;

    public NormalMove(int id, String moveType, String name, ElementType elementType, int accuracy, int priority,
                      int ammunition, double basePower) {

        super(id,moveType,name,elementType,accuracy,priority,ammunition);
        this.basePower = basePower;

    }

    public double getBasePower() {

        return basePower;
    }

    // buat method untuk dapetin nilai damage

    public void normalMove(Monster source, Monster target) {

        basePower = source.getAttack() - target.getDefense();
        double newHP = target.getHealthPoint() - basePower;
        target.setHealthPoint(newHP);
    }


}