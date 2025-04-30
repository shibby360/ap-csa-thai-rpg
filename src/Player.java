import java.util.ArrayList;

public class Player extends Entity {
    private String name;
    private Weapon weapon;
    private ArrayList<Item> inventory = new ArrayList<Item>();

    public Player(int h, int d, String n) {
        super(h, d);
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public void battlePrep(Weapon w) {
        setHealth(getMaxHealth());
        this.weapon = w;
    }

    public void battlePrep() {
        setHealth(getMaxHealth());
    }

    public int getDmgBoost() {
        int boost = 0;
        for (Item x : inventory) {
            if (x instanceof DamagePot) {
                DamagePot dx = (DamagePot) x;
                boost += dx.getBoost();
            }
        }
        return boost;
    }

    public void attack(Entity e) {
        if (weapon == null) {
            e.setHealth(e.getHealth() - (this.getDamage() + getDmgBoost()));
        } else {
            e.setHealth(e.getHealth() - (weapon.getDmg() + getDmgBoost()));
        }
    }

    public void addInv(Item i, boolean msg) {
        if (i instanceof Weapon) {
            for (Item x : inventory) {
                if (x instanceof Weapon) {
                    if (((Weapon) x).getName().equals(((Weapon) i).getName())) {
                        ((Weapon) x).setLevel(((Weapon) x).getLevel() + 0.2);
                        ((Weapon) x).setLevel(Math.round(((Weapon) x).getLevel() * 10) / 10.0);
                        if (msg)
                            System.out.println("You got a " + x);
                        return;
                    }
                }
            }
        }
        if (inventory.size() >= 10) {
            if (msg)
                System.out.println("inventory full(you can keep rolling, you might be able to upgrade a weapon)");
        } else {
            inventory.add(i);
            if (msg)
                System.out.println("You got a " + i);
        }
    }

    public int countItem(String types) {
        int i = 0;
        for (Item x : inventory) {
            if (types.indexOf(x.getId()) != -1)
                i++;
        }
        return i;
    }
}