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
        return super.toString() + "\n\tdamage: " + this.damage + "\n\tpoison length: " + this.length;
    }
}
