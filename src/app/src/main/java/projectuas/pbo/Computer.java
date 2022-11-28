package projectuas.pbo;

public class Computer extends Player {
    private int level;

    Computer() {
        this.level=1;
    }

    Computer(int level) {
        this.level=level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
