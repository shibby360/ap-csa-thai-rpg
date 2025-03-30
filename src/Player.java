import java.util.ArrayList;

public class Player extends Entity {
    String name;
    Weapon weapon;
    ArrayList <Item> inventory = new ArrayList<Item>();
    public Player(int h, int d, String n) {
        super(h,d);
        name = n;
    }
    public void battlePrep(Weapon w) {
        health = 100;
        damage = 5;
        weapon = w;
    }
    public void battlePrep() {
        health = 100;
        damage = 5;
    }
    public int getDmgBoost() {
        int boost = 0;
        for(Item x : inventory) {
            if(x instanceof DamagePot) {
                DamagePot dx = (DamagePot)x;
                boost += dx.boost;
            }
        }
        return boost;
    }
    public void attack(Entity e) {
        if(weapon == null) {
            e.health -= this.damage + getDmgBoost();
        } else {
            e.health -= weapon.damage + getDmgBoost();
        }
    }
}