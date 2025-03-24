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
}
