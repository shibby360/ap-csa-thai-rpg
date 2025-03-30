import java.util.Scanner;
public class Tools {
    static Scanner scanner = new Scanner(System.in);
    public static String input(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
    public static int intInput(String prompt) {
        System.out.print(prompt);
        String e = scanner.nextLine();
        while(!isInt(e)) {
            System.out.print(prompt);
            e = scanner.nextLine(); 
        }
        return Integer.parseInt(e);
    }
    public static void waitEnter() {
        System.out.print("[enter] to continue");
        scanner.nextLine();
    }
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static boolean isDigit(String s) {
        if(s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9") || s.equals("0") || s.equals("-")) {
            return true;
        }
        return false;
    }
    public static boolean isInt(String str) {
        for(int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i+1);
            if(!isDigit(s)) {
                return false;
            }
        }
        return true;
    }
}
