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
        if(s.equals("1") || s.equals("2") || s.equals("3") || s.equals("4") || s.equals("5") || s.equals("6") || s.equals("7") || s.equals("8") || s.equals("9") || s.equals("0")) {
            return true;
        }
        return false;
    }
    public static boolean isInt(String str) {
        if(str.length() == 0 || str.equals("-")) {
            return false;
        }
        if(str.substring(0,1).equals("-")) {
            str = str.substring(1,str.length());
        }
        for(int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i+1);
            if(!isDigit(s)) {
                return false;
            }
        }
        return true;
    }
    public static void wait(int millis) {
        try {
            Thread.sleep(millis); // Pause execution for 2000 milliseconds (2 seconds)
        } catch (InterruptedException e) {
            // Handle the exception if the sleep is interrupted
            e.printStackTrace();
        }
    }
    public static void slowPrint(String str) {
        for(int i = 0; i < str.length(); i++) {
            System.out.print(str.substring(i, i+1));
            wait(50);
        }
    }
    public static void slowPrintln(String str) {
        slowPrint(str+'\n');
    }
    public static String color(String fgbg, int r, int g, int b) {
        String end = "\033[";
        if(fgbg.equals("fg")) {
            end += "38;2;";
        } else if(fgbg.equals("bg")) {
            end += "48;2;";
        } else {
            return "\033[0m";
        }
        end += r+";"+g+";"+b+"m";
        return end;
    }
    public static String colorText(String txt, String fgbg, int r, int g, int b) {
        return color(fgbg, r, g, b) + txt + color("",0,0,0);
    }
    public static int randInt(int a, int b) {
        return (int)(Math.random()*(b-a)) + a;
    }
}
