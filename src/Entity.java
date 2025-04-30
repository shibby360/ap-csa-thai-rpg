public class Entity {
    private int health;
    private int maxHealth;
    private int damage;
    private boolean poisoned;
    private int poisonLeft;
    private int poisonDmg;
    private boolean froze;
    private int freezeLeft;

    public Entity(int h, int d) {
        this.health = h;
        this.maxHealth = h;
        this.damage = d;
    }

    public Entity() {}

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isPoisoned() {
        return poisoned;
    }

    public void setPoisoned(boolean poisoned) {
        this.poisoned = poisoned;
    }

    public int getPoisonLeft() {
        return poisonLeft;
    }

    public void setPoisonLeft(int poisonLeft) {
        this.poisonLeft = poisonLeft;
    }

    public int getPoisonDmg() {
        return poisonDmg;
    }

    public void setPoisonDmg(int poisonDmg) {
        this.poisonDmg = poisonDmg;
    }

    public boolean isFroze() {
        return froze;
    }

    public void setFroze(boolean froze) {
        this.froze = froze;
    }

    public int getFreezeLeft() {
        return freezeLeft;
    }

    public void setFreezeLeft(int freezeLeft) {
        this.freezeLeft = freezeLeft;
    }

    public void attack(Entity e) {
        e.setHealth(e.getHealth() - damage);
    }

    public void printStats() {
        if (this instanceof Player && ((Player) this).getWeapon() != null) {
            System.out.println("damage: " + (((Player) this).getWeapon().getDmg() + ((Player) this).getDmgBoost()));
        } else {
            System.out.println("damage: " + getDamage());
        }
        if (getPoisonLeft() > 0) {
            System.out.println("poison left: " + getPoisonLeft());
        }
        if (getFreezeLeft() > 0) {
            System.out.println("freeze left: " + getFreezeLeft());
        }
        System.out.println("health: (" + getHealth() + "/" + getMaxHealth() + ") " + Tools.colorText("█".repeat(getHealth()), "fg", 33, 131, 0) + "█".repeat(Math.max(getMaxHealth() - getHealth(), 0)));
    }

    public void takePoison() {
        if (!isPoisoned())
            return;
        setPoisonLeft(getPoisonLeft() - 1);
        setHealth(getHealth() - getPoisonDmg());
        if (getPoisonLeft() == 0) {
            setPoisoned(false);
        }
    }

    public void takeFreeze() {
        if (!isFroze())
            return;
        setFreezeLeft(getFreezeLeft() - 1);
        if (getFreezeLeft() == 0) {
            setFroze(false);
        }
    }

    public void getPoison(PoisonPot p) {
        setPoisoned(true);
        setPoisonDmg(getPoisonDmg() + p.getDamage());
        setPoisonLeft(getPoisonLeft() + p.getLength());
    }

    public void getFreeze(FreezePot p) {
        setFroze(true);
        setFreezeLeft(getFreezeLeft() + p.getLength());
    }
}