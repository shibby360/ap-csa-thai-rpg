import java.util.Scanner;
public class Tools {
    static Scanner scanner = new Scanner(System.in);
    public static String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    public static void waitEnter() {
        System.out.print("[enter] to continue");
        scanner.nextLine();
    }
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public Potion getPotion(String id) {
        String[] parts = id.split(";");
        if(parts[0].equals("damage potion")) {
            return new DamagePot(Integer.parseInt(parts[1]));
        } else if(parts[0].equals("freezing potion")) {
            return new FreezePot(Integer.parseInt(parts[1]));
        } else if(parts[0].equals("healing potion")) {
            return new HealPot(Integer.parseInt(parts[1]));
        } else if(parts[0].equals("poison potion")) {
            return new PoisonPot(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
        } else {
            return null;
        }
    }
    public Weapon getWeapon(String id) {
        return new Weapon(Integer.parseInt(id.split(";")[0]), id.split(";")[1]);
    }
}
