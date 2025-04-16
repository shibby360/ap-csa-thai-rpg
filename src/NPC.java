public class NPC {
    String[] dialogue;
    boolean met;
    String type;
    public NPC(String t, String[] d) {
        type = t;
        dialogue = d;
    }
    public void meet() {
        if(met) 
            return;
        Tools.slowPrintln("you met a/an " + type + "! they said: ");
        for(String x : dialogue) {
            Tools.slowPrintln(x);
            Tools.wait(250);
        }
        Tools.waitEnter();
        met = true;
    }
}