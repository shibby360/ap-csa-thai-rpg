public class Enemy extends Entity {
    String type;
    int freezeChance;
    FreezePot freezePot;
    int poisonChance;
    PoisonPot poisonPot;
    public Enemy(int h, int d, String t) {
        super(
            ((int)(Math.random()*(10))+(h-5)),
            ((int)(Math.random()*(10))+(d-5))
        );
        type = t;
        freezePot = new FreezePot(0);
        poisonPot = new PoisonPot(0, 0);
    }
    public Enemy(int h, int d, String t, int frL, int frC, int poiC ,int poiD, int poiL) {
        super(
            ((int)(Math.random()*(10))+(h-5)),
            ((int)(Math.random()*(10))+(d-5))
        );
        type = t;
        freezeChance = frC;
        freezePot = new FreezePot(frL);
        poisonChance = poiC;
        poisonPot = new PoisonPot(poiD, poiL);
    }
    public void effects(Entity e) {
        System.out.println(poisonChance);
        if(Math.random()*10 < poisonChance) {
            System.out.println("poisoned");
            e.getFreeze(freezePot);
        }
        if(Math.random()*10 < freezeChance) {
            System.out.println("frozen");
            e.getPoison(poisonPot);
        }
        Tools.waitEnter();
    }
}