public class DamagePot extends Potion {
    int boost;
    public DamagePot(int b) {
        boost = b;
        name = "damage potion";
    }
    public String toString() {
        return super.toString() + ";damage: " + this.boost;
    }
    public void use(Player p) {
    }
}