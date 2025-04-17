public class Levels {
    public static Enemy[][] levels() {
        Enemy[][] end = {
            { new Enemy(15, 15, "monster"), new Enemy(15, 15, "boss") },
            { new Enemy(25, 15, "monster"), new Enemy(35, 15, "boss") },
            { new Enemy(15, 15, "monster"), new Enemy(25, 15, "monster"), new Enemy(25,25,"boss")},
            { new Enemy(20, 20, "monster"), new Enemy(25, 15, "monster"), new Enemy(25,30,"boss")},
            { new Enemy(15, 20, "monster"), new Enemy(25, 15, "monster"), new Enemy(25,25,"monster"), new Enemy(25,30,"boss")},
            { new Enemy(20, 20, "monster"), new Enemy(25, 25, "monster"), new Enemy(25,25,"monster"), new Enemy(35,40,"boss")},
            { new Enemy(25, 25, "monster"), new Enemy(25, 25, "monster"), new Enemy(25,25,"monster"), new Enemy(45,50,"boss")},
            { new Enemy(30, 20, "monster"), new Enemy(35, 25, "monster"), new Enemy(45,15,"monster"), new Enemy(40,30,"monster"), new Enemy(55,55,"boss")},
            { new Enemy(30, 25, "monster"), new Enemy(40, 30, "monster"), new Enemy(45,30,"monster"), new Enemy(35,45,"monster"), new Enemy(60,65,"boss")},
            { new Enemy(15, 15, "monster"), new Enemy(30, 30, "monster"), new Enemy(35,40,"monster"), new Enemy(45,45,"monster"), new Enemy(50,60, "monster"), new Enemy(75,75,"boss")}
        };
        return end;
    }
}