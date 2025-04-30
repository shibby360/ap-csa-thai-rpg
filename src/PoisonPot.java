public class PoisonPot extends Potion {
    private int damage;
    private int length;

    public PoisonPot(int d, int l) {
        this.damage = d;
        this.length = l;
        setName("poison potion");
        setId("poison");
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String toString() {
        return super.toString() + "\n\tdamage: " + this.damage + "\n\tpoison length: " + this.length;
    }
}
