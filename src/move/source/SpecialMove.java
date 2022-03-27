public class SpecialMove extends Move {
        // implements EffectOfMove

    private int basePower;
    private int damage;

    // Konstuktor

    public SpecialMove(int id, int basePower) {

        super(id);
        this.basePower = basePower;
        damage = 0;
    }

    // Membuat static method untuk kelas ini??
    // Buat ngitung damage

    public static

    // Getter dan Setter kelas SpecialMove

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

    // Implementasi interface effect of move??
}
