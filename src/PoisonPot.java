public class PoisonPot extends Potion {
    int damage;
    int length;
    public PoisonPot(int d, int l) {
        damage = d;
        length = l;
        name = "poison potion";
    }
    public String toString() {
        return super.toString() + ";" + this.damage + ";" + this.length;
    }
}
