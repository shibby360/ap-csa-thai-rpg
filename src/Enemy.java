public class Enemy extends Entity {
    String type;
    public Enemy(int h, int d, String t) {
        super(
            ((int)(Math.random()*(10))+h),
            ((int)(Math.random()*(10))+d)
        );
        type = t;
    }
}