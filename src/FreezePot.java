public class FreezePot extends Potion {
    int length;
    public FreezePot(int l) {
        length = l;
        name = "freezing potion";
    }
    public String toString() {
        return super.toString() + ";freeze length: " + this.length;
    }
}
