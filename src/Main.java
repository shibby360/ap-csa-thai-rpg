public class Main {
    public static void main(String[] args) {
        String name = Tools.input("whats your name? ");
        Weapon sword = new Weapon(0, "ffer");
        Player p = new Player(100, 5, name);
        while(true) {
            Tools.clear();
            String c = Tools.input("[1]level\n[2]check stats\n[3]exit\n");
            if(c.equals("1")) {
                String lc = Tools.input("pick a level 1-2: \n");
                while(p.health > 0) {
                    if() {

                    }
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