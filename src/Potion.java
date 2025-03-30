public class Potion extends Item {
    String name;
    public Potion() {
        usable = true;
    }
    public String toString() {
        return "potion:"+this.name;
    }
    public void use(Player p) {
        
    }
}