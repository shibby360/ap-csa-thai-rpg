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
                    while(wc < -1 || wc >= weapons.size()) {
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
                        int ac = Tools.intInput("[1]attack\n[2]potion\n");
                        if(ac == 1) {
                            p.attack(x);
                        } else if(ac == 2) {
                            // what if they just suck and don't have any potions
                            int pc = Tools.intInput("[1]heal potion\n[2]poison potion\n[3]freeze potion\n");
                            String nm = "";
                            ArrayList<Potion> potions = new ArrayList<Potion>();
                            if(pc == 1)
                                nm = "heal";
                            else if(pc == 2)
                                nm = "poison";
                            else if(pc == 3)
                                nm = "freeze";
                            i = 0;
                            for(Item y : p.inventory) {
                                if(y instanceof Potion) {
                                    if(((Potion)y).name.startsWith(nm)) {
                                        potions.add((Potion)y);
                                        System.out.println(i + ": " + (Potion)y);
                                        i++;
                                    }
                                }
                            }
                            int wpc = Tools.intInput("pick a potion(index): ");
                            while(wpc < 0 && wpc >= potions.size()) {
                                wpc = Tools.intInput("pick a potion(index): ");
                            }
                            Potion pot = potions.get(wpc);
                            if(pot instanceof FreezePot) {
                                x.getFreeze((FreezePot)pot);
                            } else if(pot instanceof HealPot) {
                                p.health += ((HealPot)pot).heal;
                            } else if(pot instanceof PoisonPot) {
                                x.getPoison((PoisonPot)pot);
                            }
                        }

                        x.attack(p);
                        x.takeFreeze();
                        x.takePoison();
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
                // add item dropability
                for(Item x : p.inventory) {
                    System.out.println(x);
                }
                Tools.waitEnter();
            } else if(c.equals("3")) {
                Item item = items[(int)(Math.random()*items.length)];
                p.addInv(item, true);
                Tools.waitEnter();
            } else if(c.equals("4")) {
                break;
            }
        }
    }
}