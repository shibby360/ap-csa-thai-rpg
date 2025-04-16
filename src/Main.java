import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // String name = Tools.input("whats your name? ");
        String name = "streamline";
        int level = 1;
        Player p = new Player(100, 1, name);
        Weapon[] allWeapons = {new Weapon(3, "🪵Wooden Sword🪵"), new Weapon(3, "🪵Wooden Sword🪵"), new Weapon(3, "🪵Wooden Sword🪵"), new Weapon(3, "🪵Wooden Sword🪵"), new Weapon(3, "🪵Wooden Sword🪵"), new Weapon(5, "🏹Simple Bow🏹"), new Weapon(5, "🏹Simple Bow🏹"), new Weapon(5, "🏹Simple Bow🏹"), new Weapon(5, "🏹Simple Bow🏹"), new Weapon(5, "🏹Simple Bow🏹"),new Weapon(5, "⚔️Iron Sword⚔️"), new Weapon(5, "⚔️Iron Sword⚔️"), new Weapon(5, "⚔️Iron Sword⚔️"), new Weapon(8, "💎Diamond Sword💎"),new Weapon(8, "💎Diamond Sword💎"), new Weapon(20, "˚. ୭ ˚○◦˚✨Shivaurium Sword✨˚◦○˚ ୧ .˚ₓx"), new Weapon(8, "⚡Charged Bow⚡"), new Weapon(8, "⚡Charged Bow⚡"), new Weapon(8, "⚡Charged Bow⚡"), new Weapon(10, "🔥Flame Bow🔥"),new Weapon(10, "🔥Flame Bow🔥"), new Weapon(22, "˚. ୭ ˚○◦˚✨Shivaurium Bow✨˚◦○˚ ୧ .˚ₓx")};
        // Weapon[] allWeapons = {new Weapon(5, "swArd")};
        ArrayList<Item> items = new ArrayList<Item>();
        for(Weapon w : allWeapons) {
            items.add((Item)w);
        }
        for(int i = 0; i < 3; i++) {
            items.add(
                (Item)(new DamagePot(Tools.randInt(5, 15)))
            );
            items.add(
                (Item)(new FreezePot(Tools.randInt(2, 5)))
            );
            items.add(
                (Item)(new HealPot(Tools.randInt(5, 15)))
            );
            items.add(
                (Item)(new PoisonPot(Tools.randInt(5, 15), Tools.randInt(2, 5)))
            );
        }
        NPC guide = new NPC("guide", new String[]{"you're in a forest and you have to fight all the monsters to get through", "beat the levels to fight the monsters, and explore in the forest to get potions and weapons for your inventory", "tips:", "\tindex means the number at the beginning, before the colon"});
        NPC explorer = new NPC("explorer", new String[]{"here you can find different potions and weapons"});
        Tools.clear();
        System.out.print(Tools.color("fg", 33, 131, 0));
        Tools.slowPrintln("hi, " + name);
        Tools.wait(250);
        guide.meet();
        System.out.print(Tools.color("", 0, 0, 0));
        while(true) {
            Tools.clear();
            System.out.println("wsg " + p.name);
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
                for(int j = 0; j < currlevel.length; j++) {
                    Enemy x = currlevel[j];
                    while(x.health > 0 && p.health > 0) {
                        Tools.clear();
                        p.takeFreeze();
                        p.takePoison();
                        System.out.println("level " + level);
                        System.out.println(p.weapon);
                        System.out.println("boost: " + p.getDmgBoost());
                        p.printStats();
                        System.out.println();
                        System.out.println("(" + j + ")" + x.type.toUpperCase());
                        x.printStats();
                        int potionCount = p.countItem("freeze,heal,poison");
                        String prompt = "";
                        if(!p.froze) {
                            prompt = "[1]attack\n";
                        } else {
                            System.out.print("frozen, ");
                            Tools.waitEnter();
                        }
                        if(potionCount > 0 && !p.froze)
                            prompt += "[2]potion\n";
                        int ac = 0;
                        if(!p.froze)
                            ac = Tools.intInput(prompt);
                        boolean enemyAtk = true;
                        if(ac == 1 && !p.froze) {
                            p.attack(x);
                        } else if(ac == 2 && potionCount > 0 && !p.froze) {
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
                                enemyAtk = false;
                            } else if(pot instanceof PoisonPot) {
                                x.getPoison((PoisonPot)pot);
                            }
                            p.inventory.remove((Item)pot);
                        }

                        if(x.health <= 0) {
                            continue;
                        }
                        if(!x.froze && enemyAtk) {
                            x.attack(p);
                            x.effects(p);
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
                    if(level == Levels.levels().length) {
                        System.out.println("you finished the whole game yay");
                        break;
                    } else {
                        level ++;
                    }
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
                explorer.meet();
                Item item = items.get((int)(Tools.randInt(0, items.size())));
                p.addInv(item, true);
                Tools.waitEnter();
            } else if(c.equals("4")) {
                break;
            }
        }
    }
}