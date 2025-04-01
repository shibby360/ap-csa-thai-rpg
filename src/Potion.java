public class Potion extends Item {
    String name;
    public Potion() {
        usable = true;
        id = "potion";
    }
    public String toString() {
        return "potion:"+this.name;
    }
    public void use(Player p) {
        
    }
}