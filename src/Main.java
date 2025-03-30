import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // String name = Tools.input("whats your name? ");
        String name = "streamline";
        int level = 1;
        Player p = new Player(150, 10, name);
        Item[] items = {new FreezePot(2), new HealPot(10), new DamagePot(10), new PoisonPot(5, 3), new Weapon(3, "🪵Wooden Sword🪵"), new Weapon(5, "🏹Simple Bow🏹"),new Weapon(5, "⚔️Iron Sword⚔️"), new Weapon(8, "💎Diamond Sword💎"), new Weapon(20, "˚. ୭ ˚○◦˚✨Shivaurium Sword✨˚◦○˚ ୧ .˚ₓx"), new Weapon(8, "⚡Charged Bow⚡"), new Weapon(10, "🔥Flame Bow🔥"), new Weapon(22, "˚. ୭ ˚○◦˚✨Shivaurium Bow✨˚◦○˚ ୧ .˚ₓx")};
        while(true) {
            Tools.clear();
            String c = Tools.input("[1]play(level " + level + ")\n[2]inventory\n[3]explore\n[4]exit\n");
            if(c.equals("1")) {
                Enemy[] currlevel = Levels.levels()[level-1];
                ArrayList<Weapon> weapons = new ArrayList<Weapon>();
                int i = 0;
                for(Item x : p.inventory) {
                    if(x instanceof Weapon) {
                        System.out.println(i + ": " + x);
                        weapons.add((Weapon)x);
                        i++;
                    }
                }
                System.out.println("current: " + p.weapon);
                if(weapons.size() != 0) {
                    int wc = Tools.intInput("pick a weapon(index, -1 for current): ");
                    while(wc < -1 || wc > weapons.size()) {
                        wc = Tools.intInput("pick a weapon(index, -1 for current): ");
                    }
                    if(wc == -1) {
                        p.battlePrep();
                    } else {
                        p.battlePrep(weapons.get(wc));
                    }
                } else {
                    p.battlePrep();
                }
                for(Enemy x : currlevel) {
                    while(x.health > 0 && p.health > 0) {
                        Tools.clear();
                        System.out.println("level " + level);
                        System.out.println(p.weapon);
                        System.out.println("boost: " + p.getDmgBoost());
                        System.out.println(x.type.toUpperCase()+"\nhealth: " + p.health + "\nenemy health: " + x.health);
                        // add attack or potion use option
                        p.attack(x);
                        x.attack(p);
                        Tools.waitEnter();
                        Tools.clear();
                    }
                    if(p.health <= 0) {
                        System.out.println("you got deaded :( 💀");
                        break;
                    }
                }
                if(p.health > 0) {
                    System.out.println("you killed them all yay");
                    level ++;
                }
                Tools.waitEnter();
            } else if(c.equals("2")) {
                for(Item x : p.inventory) {
                    System.out.println(x);
                }
                Tools.waitEnter();
            } else if(c.equals("3")) {
                // explore
                // add inventory cap limit
                p.inventory.add(items[(int)(Math.random()*items.length)]);
                System.out.println("You got a " + p.inventory.get(p.inventory.size()-1)+ "!");
                Tools.waitEnter();
            } else if(c.equals("4")) {
                break;
            }
        }
    }
}