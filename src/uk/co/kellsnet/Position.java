package uk.co.kellsnet;

public class Position {

    private int y;
    private int x;

    public Position (int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void set(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
