import java.util.ArrayList;

public class Player extends Entity {
    String name;
    Weapon weap;
    ArrayList <String> inventory = new ArrayList<String>();
    public Player(int h, int d, String n) {
        super(h,d);
        name = n;
    }
    public void battlePrep() {
        health = 100;
        damage = 5;
    }
}