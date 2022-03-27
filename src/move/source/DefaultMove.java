public class DefaultMove extends Move {

    private Stats healthPoint;
    private int basePower;

    public DefaultMove(int id, Stats healthPoint) {

        super(id);
        basePower = 50;
        this.healthPoint = healthPoint;
    }

    public DefaultMove(int basePower, Stats healthPoint) {

        super(100,0,200); // nilai ammunition di set menjadi 200
        basePower = 50;
        this.healthPoint = healthPoint;
    }

    // Getter dan Setter

    public int getBasePower() {

        return basePower;
    }

    public Stats getHealthPoint() {
        return healthPoint;
    }

    public void setHealthPoint() {

        this.healthPoint = healthPoint;
    }
}
