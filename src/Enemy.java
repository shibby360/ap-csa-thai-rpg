public class Enemy extends Entity {
    private String type;
    private int freezeChance;
    private FreezePot freezePot;
    private int poisonChance;
    private PoisonPot poisonPot;

    public Enemy(int h, int d, String t) {
        super(((int) (Math.random() * (10)) + (h - 5)), ((int) (Math.random() * (10)) + (d - 5)));
        this.type = t;
        this.freezePot = new FreezePot(0);
        this.poisonPot = new PoisonPot(0, 0);
    }

    public Enemy(int h, int d, String t, int frL, int frC, int poiC, int poiD, int poiL) {
        super(((int) (Math.random() * (10)) + (h - 5)), ((int) (Math.random() * (10)) + (d - 5)));
        this.type = t;
        this.freezeChance = frC;
        this.freezePot = new FreezePot(frL);
        this.poisonChance = poiC;
        this.poisonPot = new PoisonPot(poiD, poiL);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getFreezeChance() {
        return freezeChance;
    }

    public void setFreezeChance(int freezeChance) {
        this.freezeChance = freezeChance;
    }

    public FreezePot getFreezePot() {
        return freezePot;
    }

    public void setFreezePot(FreezePot freezePot) {
        this.freezePot = freezePot;
    }

    public int getPoisonChance() {
        return poisonChance;
    }

    public void setPoisonChance(int poisonChance) {
        this.poisonChance = poisonChance;
    }

    public PoisonPot getPoisonPot() {
        return poisonPot;
    }

    public void setPoisonPot(PoisonPot poisonPot) {
        this.poisonPot = poisonPot;
    }

    public void effects(Entity e) {
        if (Math.random() * 10 < poisonChance) {
            e.getFreeze(freezePot);
        }
        if (Math.random() * 10 < freezeChance) {
            e.getPoison(poisonPot);
        }
    }
}