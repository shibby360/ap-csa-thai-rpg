public class Main {
    public static void main(String[] args) {
        
        String name = Tools.input("whats your name? ");
        while(true) {
            Tools.clear();
            String c = Tools.input("[1]level\n[2]check stats\n");
            if(c.equals("1")) {
                System.out.println("no levels yet :(");
                Tools.waitEnter();
            } else if(c.equals("2")) {
                System.out.println(name);
                Tools.waitEnter();
            }
        }
    }
}