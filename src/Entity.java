public class Entity {
    int health;
    int damage;
    boolean poisoned;
    int poisonLeft;
    int poisonDmg;
    boolean froze;
    int freezeLeft;
    public Entity(int h, int d) {
        health = h;
        damage = d;
    }
    public Entity() {}
    public void attack(Entity e) {
        e.health -= damage;
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