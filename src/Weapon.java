public class Weapon extends Item {
    private int damage;
    private String name;
    private double level = 1.0;

    public Weapon(int damage, String name) {
        setUsable(false);
        this.damage = damage;
        this.name = name;
        setId("weapon");
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public String toString() {
        return "weapon: " + this.name + "\n\tdamage: " + this.getDmg() + "\n\tlevel: " + (int) level + ", " + Math.round(((level - (int) level) * 5)) + "/5";
    }

    public int getDmg() {
        return damage + 2 * (((int) level) - 1);
    }
}