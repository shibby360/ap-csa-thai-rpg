public class Main {
    public static void main(String[] args) {
        // String name = Tools.input("whats your name? ");
        String name = "streamline";
        Weapon sword = new Weapon(0, "sword");
        while(true) {
            Tools.clear();
            String c = Tools.input("[1]level\n[2]check stats\n[3]exit\n");
            if(c.equals("1")) {
                String lc = Tools.input("pick a level 1-2: \n");
                Enemy[] currlevel = Levels.levels[Integer.parseInt(lc)-1];
                Player p = new Player(100, 5, name);
                for(Enemy x : currlevel) {
                    while(x.health > 0 && p.health > 0) {
                        System.out.println(x.type.toUpperCase()+"\nhealth: " + p.health + "\nenemy health: " + x.health);
                        p.attack(x);
                        x.attack(p);
                        Tools.waitEnter();
                        Tools.clear();
                    }
                    if(p.health <= 0) {
                        System.out.println("you got deaded :(");
                        break;
                    }
                }
                if(p.health > 0) {
                    System.out.println("you killed them all yay");
                }
                Tools.waitEnter();
            } else if(c.equals("2")) {
                System.out.println(name);
                Tools.waitEnter();
            } else if(c.equals("3")) {
                break;
            }
        }
    }
}