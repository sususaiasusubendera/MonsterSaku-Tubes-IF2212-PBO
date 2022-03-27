public abstract class Move {

    private int id;
    private String moveType;
    private String name;
    private ElementType elementType;
    private int accuracy;
    private int priority;
    private int ammunition;
    private TargetOfMove target;
    private int effect;

    // Konstruktor Kelas Move
    // id berisi bilangan bulat positif unik

    public Move(int id) {

        this.id = id;
        this.moveType = moveType;
        this.name = name;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
        this.target = target;
        this.effect = effect;

    }

    public Move(int accuracy, int priority, int ammunition) {

        this.id = id;
        this.moveType = moveType;
        this.name = name;
        this.elementType = elementType;
        this.accuracy = accuracy;
        this.priority = priority;
        this.ammunition = ammunition;
        this.target = target;
        this.effect = effect;

    }

    // Setter Kelas Move

    public void setId (int id) {

        this.id = id;

    }

    public void setMoveType (String moveType) {

        this.moveType = moveType;

    }

    // Mengeset nama dari Move
    public  void setName (String name) {

        this.name = name;

    }

    // Tipe elemen yang dimiliki oleh move
    // Dapat menentukan efektivitasnya terhadap target monster.
    public void setElementType (ElementType elementType) {

        this.elementType = elementType;

    }

    public void setAccuracy (int accuracy) {

        this.accuracy = accuracy;

    }

    public void setPriority (int priority) {

        this.priority = priority;

    }

    public void setAmmunition (int ammunition) {

        this.ammunition = ammunition;
    }

    // public void setTarget (TargetOfMove target) {

    //     this.target = target;
    // }

    public void setEffect (String effect) {

        this.effect = effect;
    }


    // Getter Kelas Move

    public int getId() {

        return id;
    }

    public String getMoveType() {

        return moveType;
    }

    public String getName() {

        return name;
    }

    public ElementType getElementType() {

        return this.elementType;
    }

    public int getAccuracy() {

        return accuracy;

    }

    public int getPriority() {

        return priority;

    }

    public int getAmmunition() {

        return ammunition;

    }

    public String getTarget() {

        return target;

    }

    public int getEffect() {

        return effect;
    }

    // Method dari Kelas Move

    // Abstract Method Class Move

    // public abstract void monsterMove;
    // public abstract void configMove;
}
