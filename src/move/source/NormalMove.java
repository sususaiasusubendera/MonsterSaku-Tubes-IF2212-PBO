public class NormalMove extends Move {
        // implements EffectOfMove {

    private int basePower;
    private int damage;

    public NormalMove(int id, int basePower) {

        super(id);
        this.basePower = basePower;
       // damage = 0;
    }

    // Membuat static method untuk kelas ini??
    // Buat ngitung damage

    // Getter dan Setter NormalMove

    public int getBasePower() {

        return basePower;
    }

    public void setBasePower(int basePower) {

        this.basePower = basePower;
    }

    public int getDamage() {

        this.damage = damage;
    }

    public void setDamage(int damage) {

        this.damage = damage;
    }

    // Method NormalMove

    // public void monsterMove();

    // Method dari Interface

    // public void getEffect();
}
