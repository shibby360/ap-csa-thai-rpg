public class Entity {
    int health;
    int damage;
    boolean poisoned;
    boolean froze;
    public Entity(int h, int d) {
        health = h;
        damage = d;
    }
    public Entity() {}
    public void attack(Entity e) {
        e.health -= damage;
    }
}