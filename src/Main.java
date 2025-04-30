import java.util.ArrayList;
// maybe add ifninite mode
public class Main {
    public static void main(String[] args) {
        String name = Tools.input("whats your name? ");
        int level = 1;
        Player p = new Player(100, 1, name);
        // redo weapons
        Weapon[] allWeapons = {
            new Weapon(3, "🪵 Wooden Sword🪵 "),
            new Weapon(3, "🪵 Wooden Sword🪵 "),
            new Weapon(3, "🪵 Wooden Sword🪵 "),
            new Weapon(3, "🪵 Wooden Sword🪵 "),
            new Weapon(3, "🪵 Wooden Sword🪵 "),
            new Weapon(5, "🏹 Simple Bow 🏹"),
            new Weapon(5, "🏹 Simple Bow 🏹"),
            new Weapon(5, "🏹 Simple Bow 🏹"),
            new Weapon(5, "🏹 Simple Bow 🏹"),
            new Weapon(5, "🏹 Simple Bow 🏹"),
            new Weapon(5, "⚔️ Iron Sword ⚔️ "),
            new Weapon(5, "⚔️ Iron Sword ⚔️ "),
            new Weapon(5, "⚔️ Iron Sword ⚔️ "),
            new Weapon(8, "💎Diamond Sword💎"),
            new Weapon(8, "💎Diamond Sword💎"),
            new Weapon(20, "˚. ୭ ˚○◦˚✨ ⚔️ Shivaurium Sword ⚔️ ✨˚◦○˚ ୧ .˚ₓx"),
            new Weapon(8, "⚡Charged Bow⚡"),
            new Weapon(8, "⚡Charged Bow⚡"),
            new Weapon(8, "⚡Charged Bow⚡"),
            new Weapon(10, "🔥Flame Bow🔥"),
            new Weapon(10, "🔥Flame Bow🔥"),
            new Weapon(22, "˚. ୭ ˚○◦˚✨🏹Shivaurium Bow🏹✨˚◦○˚ ୧ .˚ₓx")
        };
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
        Tools.slowPrintln("hi, " + p.getName());
        Tools.wait(250);
        if (!p.getName().equals("admin")) {
            guide.meet();
        }
        System.out.print(Tools.color("", 0, 0, 0));
        while (true) {
            Tools.clear();
            System.out.println("hi " + p.getName());
            String c = Tools.input("[1]play(level " + level + ")\n[2]inventory\n[3]explore\n[4]exit\n");
            if (c.equals("1")) {
                Enemy[] currlevel = Levels.levels()[level - 1];
                ArrayList<Weapon> weapons = new ArrayList<>();
                int i = 0;
                for (Item x : p.getInventory()) {
                    if (x instanceof Weapon) {
                        System.out.println(i + ": " + x);
                        weapons.add((Weapon) x);
                        i++;
                    }
                }
                System.out.println("current: " + p.getWeapon());
                if (weapons.size() != 0) {
                    int wc = Tools.intInput("pick a weapon(index, -1 for current, -2 to exit): ");
                    while (wc < -2 || wc >= weapons.size()) {
                        wc = Tools.intInput("pick a weapon(index, -1 for current, -2 to exit): ");
                    }
                    if (wc == -1) {
                        p.battlePrep();
                    } else if (wc == -2) {
                        continue;
                    } else {
                        p.battlePrep(weapons.get(wc));
                    }
                } else {
                    p.battlePrep();
                }
                boolean battling = true;
                for (int j = 0; j < currlevel.length && battling; j++) {
                    Enemy x = currlevel[j];
                    while (x.getHealth() > 0 && p.getHealth() > 0 && battling) {
                        Tools.clear();
                        p.takeFreeze();
                        p.takePoison();
                        System.out.println("level " + level);
                        System.out.println("input -1 at any time to skip/reset turn");
                        System.out.println(p.getWeapon());
                        System.out.println("boost: " + p.getDmgBoost());
                        p.printStats();
                        System.out.println();
                        System.out.println("(" + j + ")" + x.getType().toUpperCase());
                        x.printStats();
                        boolean enemyTurn = true;
                        int potionCount = p.countItem("freeze,heal,poison");
                        String prompt = "[-2]leave battle\n";
                        if (!p.isFroze()) { // Use getter for 'froze'
                            prompt += "[1]attack\n";
                        } else {
                            System.out.print("frozen, ");
                            Tools.waitEnter();
                        }
                        if (potionCount > 0 && !p.isFroze()) { // Use getter for 'froze'
                            prompt += "[2]potion\n";
                        }
                        int ac = 0;
                        if (!p.isFroze()) { // Use getter for 'froze'
                            ac = Tools.intInput(prompt);
                            while (ac < -2 || ac > 2) {
                                ac = Tools.intInput(prompt);
                            }
                        }
                        if (ac == -1) {
                            enemyTurn = false;
                        } else if (ac == -2) {
                            System.out.println("left battle");
                            battling = false;
                            break;
                        }
                        if (ac == 1 && !p.isFroze()) { // Use getter for 'froze'
                            p.attack(x);
                        } else if (ac == 2 && potionCount > 0 && !p.isFroze()) { // Use getter for 'froze'
                            prompt = "";
                            if (p.countItem("heal") > 0) {
                                prompt += "[1]heal potion\n";
                            }
                            if (p.countItem("poison") > 0) {
                                prompt += "[2]poison potion\n";
                            }
                            if (p.countItem("freeze") > 0) {
                                prompt += "[3]freeze potion\n";
                            }
                            int pc = Tools.intInput(prompt);
                            if (pc == -1) {
                                enemyTurn = false;
                                continue;
                            }
                            while (enemyTurn && (pc < 1 || pc > 3)) {
                                pc = Tools.intInput("invalid, pick another: ");
                            }
                            String nm = (new String[]{"heal", "poison", "freeze"})[pc - 1];
                            while (p.countItem(nm) == 0) {
                                pc = Tools.intInput("invalid, pick another: ");
                                if (pc == -1) {
                                    enemyTurn = false;
                                    continue;
                                }
                                while (enemyTurn && (pc < 1 || pc > 3)) {
                                    pc = Tools.intInput("invalid, pick another: ");
                                }
                                nm = (new String[]{"heal", "poison", "freeze"})[pc - 1];
                            }
                            ArrayList<Potion> potions = new ArrayList<Potion>();
                            i = 0;
                            for (Item y : p.getInventory()) { // Use getter for 'inventory'
                                if (y instanceof Potion && y.getId().equals(nm)) { // Use getter for 'id'
                                    potions.add((Potion) y);
                                    System.out.println(i + ": " + (Potion) y);
                                    i++;
                                }
                            }
                            int wpc = Tools.intInput("pick a potion(index): ");
                            if (wpc == -1) {
                                enemyTurn = false;
                                continue;
                            }
                            while (enemyTurn && (wpc < 0 || wpc >= potions.size())) {
                                wpc = Tools.intInput("pick a potion(index): ");
                            }
                            Potion pot = potions.get(wpc);
                            if (pot instanceof FreezePot) {
                                x.getFreeze((FreezePot) pot);
                            } else if (pot instanceof HealPot) {
                                p.setHealth(p.getHealth() + ((HealPot) pot).getHeal()); // Use getter and setter for 'health' and 'heal'
                                enemyTurn = false;
                            } else if (pot instanceof PoisonPot) {
                                x.getPoison((PoisonPot) pot);
                            }
                            p.getInventory().remove((Item) pot); // Use getter for 'inventory'
                        }

                        if (x.getHealth() <= 0) {
                            continue;
                        }
                        if (!x.isFroze() && enemyTurn) {
                            x.attack(p);
                            x.effects(p);
                        }
                        x.takeFreeze();
                        x.takePoison();
                        Tools.waitEnter();
                        Tools.clear();
                        if (p.getHealth() <= 0) { // Use getter for 'health'
                            System.out.println("you got deaded :( 💀");
                            break;
                        }
                    }
                }
                if (p.getHealth() > 0 && battling) { // Use getter for 'health'
                    System.out.println("you killed them all yay");
                    if (level == Levels.levels().length) {
                        System.out.println("you finished the whole game yay");
                        break;
                    } else {
                        level++;
                    }
                }
                Tools.waitEnter();
            } else if (c.equals("2")) {
                for (int i = 0; i < p.getInventory().size(); i++) { // Use getter for 'inventory'
                    System.out.println(i + ": " + p.getInventory().get(i)); // Use getter for 'inventory'
                }
                int ic = Tools.intInput("pick an item to drop(index, -1 to exit): ");
                while (ic < -1 || ic >= p.getInventory().size()) { // Use getter for 'inventory'
                    ic = Tools.intInput("pick an item to drop(index, -1 to exit): ");
                }
                if (ic != -1) {
                    p.getInventory().remove(ic); // Use getter for 'inventory'
                }
            } else if (c.equals("3")) {
                if (!p.getName().equals("admin")) { // Use getter for 'name'
                    explorer.meet();
                }
                Item item = items.get((int) (Tools.randInt(0, items.size())));
                p.addInv(item, true);
                Tools.waitEnter();
            } else if (c.equals("4")) {
                break;
            }
        }
    }
}