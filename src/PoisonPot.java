public class PoisonPot extends Potion {
    int damage;
    int length;
    public PoisonPot(int d, int l) {
        damage = d;
        length = l;
        name = "poison potion";
        id = "poison";
    }
    public String toString() {
        return super.toString() + ";damage: " + this.damage + ";poison length: " + this.length;
    }
}
