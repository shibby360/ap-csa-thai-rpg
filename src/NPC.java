public class NPC {
    private String[] dialogue;
    private boolean met;
    private String type;

    public NPC(String t, String[] d) {
        this.type = t;
        this.dialogue = d;
    }

    public String[] getDialogue() {
        return dialogue;
    }

    public void setDialogue(String[] dialogue) {
        this.dialogue = dialogue;
    }

    public boolean isMet() {
        return met;
    }

    public void setMet(boolean met) {
        this.met = met;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void meet() {
        if (met)
            return;
        Tools.slowPrintln("you met a/an " + type + "! they said: ");
        for (String x : dialogue) {
            Tools.slowPrintln(x);
            Tools.wait(250);
        }
        Tools.waitEnter();
        met = true;
    }
}