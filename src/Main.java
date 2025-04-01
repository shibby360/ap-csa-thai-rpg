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
                        // display healths with a bar
                        System.out.println(x.type.toUpperCase()+"\nhealth: " + p.health + "\nenemy health: " + x.health);
                        int potionCount = p.countItem("freeze,heal,poison");
                        String prompt = "[1]attack\n";
                        if(potionCount > 0)
                            prompt += "[2]potion\n";
                        int ac = Tools.intInput(prompt);
                        if(ac == 1) {
                            p.attack(x);
                        } else if(ac == 2 && potionCount > 0) {
                            prompt = "";
                            if(p.countItem("heal") > 0)
                                prompt += "[1]heal potion\n";
                            if(p.countItem("poison") > 0)
                                prompt += "[2]poison potion\n";
                            if(p.countItem("freeze") > 0)
                                prompt += "[3]freeze potion\n";
                            int pc = Tools.intInput(prompt);
                            while(pc < 1 || pc > 3) {
                                pc = Tools.intInput("invalid, pick another: ");
                            }
                            String nm = (new String[]{"heal", "poison", "freeze"})[pc-1];
                            while(p.countItem(nm) == 0) {
                                pc = Tools.intInput("invalid, pick another: ");
                                while(pc < 1 || pc > 3) {
                                    pc = Tools.intInput("invalid, pick another: ");
                                }
                                nm = (new String[]{"heal", "poison", "freeze"})[pc-1];
                            }
                            ArrayList<Potion> potions = new ArrayList<Potion>();
                            i = 0;
                            for(Item y : p.inventory) {
                                if(y instanceof Potion && y.id.equals(nm)) {
                                    potions.add((Potion)y);
                                    System.out.println(i + ": " + (Potion)y);
                                    i++;
                                }
                            }
                            int wpc = Tools.intInput("pick a potion(index): ");
                            while(wpc < 0 || wpc >= potions.size()) {
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
                            p.inventory.remove((Item)pot);
                        }
                        if(!x.froze) {
                            x.attack(p);
                        }
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
                for(int i = 0; i < p.inventory.size(); i++) {
                    System.out.println(i + ": " + p.inventory.get(i));
                }
                int ic = Tools.intInput("pick an item to drop(index, -1 to exit): ");
                while(ic < -1 || ic >= p.inventory.size()) {
                    ic = Tools.intInput("pick an item to drop(index, -1 to exit): ");
                }
                if(ic != -1) {
                    p.inventory.remove(ic);
                }
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