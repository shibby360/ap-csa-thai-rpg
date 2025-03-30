public class HealPot extends Potion {
    int heal;
    public HealPot(int h) {
        heal = h;
        name = "healing potion";
    }
    public String toString() {
        return super.toString() + ";heal: " + this.heal;
    }
}
