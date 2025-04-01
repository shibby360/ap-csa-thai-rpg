public class Entity {
    int health;
    int maxHealth;
    int damage;
    boolean poisoned;
    int poisonLeft;
    int poisonDmg;
    boolean froze;
    int freezeLeft;
    public Entity(int h, int d) {
        health = h;
        maxHealth = h;
        damage = d;
    }
    public Entity() {}
    public void attack(Entity e) {
        e.health -= damage;
    }
    public void printStats() {
        if(this instanceof Player && ((Player)this).weapon != null) {
            System.out.println("damage: " + ((Player)this).weapon.getDmg());
        } else {
            System.out.println("damage: " + damage);
        }
        if(this instanceof Enemy) {
            System.out.println("poison left: " + poisonLeft);
            System.out.println("freeze left: " + freezeLeft);
        }
        System.out.println("health: " + "\033[0;32m" + "-".repeat(health) + "\033[0m" + "-".repeat(maxHealth-health) + health + "/" + maxHealth);
    }
    public void takePoison() {
        if(!poisoned)
            return;
        poisonLeft -= 1;
        health -= poisonDmg;
        if(poisonLeft == 0) {
            poisoned = false;
        }
    }
    public void takeFreeze() {
        if(!froze)
            return;
        freezeLeft -= 1;
        if(freezeLeft == 0) {
            froze = false;
        }
    }
    public void getPoison(PoisonPot p) {
        poisoned = true;
        poisonDmg = p.damage;
        poisonLeft = p.length;
    }
    public void getFreeze(FreezePot p) {
        froze = true;
        freezeLeft = p.length;
    }
}