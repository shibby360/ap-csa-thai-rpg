public class HealPot extends Potion {
    int heal;
    public HealPot(int h) {
        heal = h;
        name = "healing potion";
        id = "heal";
    }
    public String toString() {
        return super.toString() + "\n\theal: " + this.heal;
    }
}
