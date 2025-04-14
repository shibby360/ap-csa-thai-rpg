public class Weapon extends Item {
    int damage;
    String name;
    double level = 1.0;

    public Weapon(int damage, String name){
        usable = false;
        this.damage = damage;
        this.name = name;
        id = "weapon";
    }
    public String toString() {
        return "weapon:"+this.name + ";damage: " + this.getDmg() + ";level: " + (int)level + ", " + Math.round(((level-(int)level)*5)) + "/5";
    }
    public int getDmg() {
        return damage + 2*(((int)level)-1);
    }
}