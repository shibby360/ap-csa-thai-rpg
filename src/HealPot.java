public class HealPot extends Potion {
    private int heal;

    public HealPot(int h) {
        this.heal = h;
        setName("healing potion");
        setId("heal");
    }

    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }

    public String toString() {
        return super.toString() + "\n\theal: " + this.heal;
    }
}
