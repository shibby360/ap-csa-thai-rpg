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
            e.health -= weapon.getDmg() + getDmgBoost();
        }
    }
    public void addInv(Item i, boolean msg) {
        if(inventory.size() >= 10) {
            if(msg)
                System.out.println("inventory full");
            return;
        } 
        if(i instanceof Weapon) {
            for(Item x : inventory) {
                if(x instanceof Weapon) {
                    if(((Weapon)x).name.equals(((Weapon)i).name)) {
                        ((Weapon)x).level += 0.2;
                        ((Weapon)x).level = Math.round(((Weapon)x).level * 10) / 10.0;
                        if(msg)
                            System.out.println("You got a " + x);
                        return;
                    }
                }
            }
            inventory.add(i);
            if(msg)
                System.out.println("You got a " + i);
            return;
        }
        inventory.add(i);
        if(msg)
            System.out.println("You got a " + i);
    }
    public void remInv(Item it) {
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i) == it) {
                inventory.remove(i);
            }
        }
    }
}