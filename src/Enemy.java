public class Enemy extends Entity {
    String type;
    public Enemy(int h, int d, String t) {
        super(h*(t=="boss"?3:1),d*(t=="boss"?2:1));
        type = t;
    }
}