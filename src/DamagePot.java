public class DamagePot extends Potion {
    private int boost;

    public DamagePot(int b) {
        this.boost = b;
        setName("damage potion");
        setId("damage");
    }

    public int getBoost() {
        return boost;
    }

    public void setBoost(int boost) {
        this.boost = boost;
    }

    public String toString() {
        return super.toString() + "\n\tdamage: " + this.boost;
    }

    public void use(Player p) {}
}