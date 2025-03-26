public class Levels {
    public static Enemy[][] levels() {
        Enemy[][] end = {
            { new Enemy(10, 10, "monster"), new Enemy(10, 10, "boss") },
            { new Enemy(20, 10, "monster"), new Enemy(30, 10, "boss") },
            { new Enemy(10, 10, "monster"), new Enemy(20, 10, "monster"), new Enemy(20,20,"boss")},
            { new Enemy(15, 15, "monster"), new Enemy(20, 10, "monster"), new Enemy(20,25,"boss")},
            { new Enemy(10, 15, "monster"), new Enemy(20, 10, "monster"), new Enemy(20,20,"monster"), new Enemy(25,30,"boss")},
            { new Enemy(15, 15, "monster"), new Enemy(20, 20, "monster"), new Enemy(20,20,"monster"), new Enemy(30,35,"boss")},
            { new Enemy(20, 20, "monster"), new Enemy(20, 20, "monster"), new Enemy(20,20,"monster"), new Enemy(40,45,"boss")},
            { new Enemy(25, 15, "monster"), new Enemy(30, 20, "monster"), new Enemy(40,10,"monster"), new Enemy(35,25,"monster"), new Enemy(50,50,"boss")},
            { new Enemy(25, 20, "monster"), new Enemy(35, 25, "monster"), new Enemy(40,25,"monster"), new Enemy(30,40,"monster"), new Enemy(55,60,"boss")},
            { new Enemy(10, 10, "monster"), new Enemy(20, 20, "monster"), new Enemy(30,35,"monster"), new Enemy(40,40,"monster"), new Enemy(50, 55, "monster"), new Enemy(70,70,"boss")}
        };
        return end;
    }
}