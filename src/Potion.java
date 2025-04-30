public class Potion extends Item {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Potion() {
        setUsable(true);
        setId("potion");
    }

    public String toString() {
        return "potion:" + this.name;
    }

    public void use(Player p) {}
}