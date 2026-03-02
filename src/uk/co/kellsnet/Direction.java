package uk.co.kellsnet;

public enum Direction {
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    private final int dx;
    private final int dy;

    Direction(int dy, int dx) {
        this.dy = dy;
        this.dx = dx;
    }

    public int dy() {return dy;}
    public int dx() {return dx;}
}
