public class Main {
    public static void main(String[] args) {
        // String name = Tools.input("whats your name? ");
        String name = "streamline";
        int level = 1;
        Player p = new Player(100, 5, name);
        Potion[] potions = {new FreezePot(2), new HealPot(10), new DamagePot(10)};
        Weapon[] weapons = {new Weapon(10, "sword"), new Weapon(15, "bow and arrow")};
        while(true) {
            Tools.clear();
            String c = Tools.input("[1]play(level " + level + ")\n[2]check stats\n[3]explore\n[4]exit\n");
            if(c.equals("1")) {
                Enemy[] currlevel = Levels.levels()[level-1];
                p.battlePrep();
                for(Enemy x : currlevel) {
                    while(x.health > 0 && p.health > 0) {
                        Tools.clear();
                        System.out.println("level " + level);
                        System.out.println(x.type.toUpperCase()+"\nhealth: " + p.health + "\nenemy health: " + x.health);
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
                System.out.println(name);
                Tools.waitEnter();
            } else if(c.equals("3")) {
                // explore
                if((int)Math.random()*2 == 1){
                    p.inventory.add(weapons[(int)Math.random()*weapons.length].toString());
                }else{
                    p.inventory.add(potions[(int)Math.random()*potions.length].toString());
                }
            } else if(c.equals("4")) {
                break;
            }
        }
    }
}