public class Weapon extends Item {
    int damage;
    String name;

    public Weapon(int damage, String name){
        usable = false;
        this.damage = damage;
        this.name = name;
    }
    public String toString() {
        return "weapon:"+this.name + ";damage: " + this.damage;
    }
}