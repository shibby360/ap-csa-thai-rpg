public class Levels {
    static Enemy[][] levels = {
        { new Enemy(10, 10, "monster"), new Enemy(10, 10, "boss") },
        { new Enemy(20, 10, "monster"), new Enemy(30, 10, "boss") }
    };
    public static void allLevels() {
        for(Enemy[] x : levels) {
            for(Enemy y : x) {
                System.out.print(y.type + ", ");
            }
            System.out.println();
        }
    }
}