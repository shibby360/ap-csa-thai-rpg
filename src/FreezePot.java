public class FreezePot extends Potion {
    private int length;

    public FreezePot(int l) {
        this.length = l;
        setName("freezing potion");
        setId("freeze");
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String toString() {
        return super.toString() + "\n\tfreeze length: " + this.length;
    }
}
