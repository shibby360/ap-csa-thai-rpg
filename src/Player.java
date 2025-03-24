public class Player extends Entity {
    String name;
    Weapon weap;
    public Player(int h, int d, String n) {
        super(h,d);
        name = n;
    }
}