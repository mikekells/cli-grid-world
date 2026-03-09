package uk.co.kellsnet;

public class Door extends Entity{

    private boolean open = false;

    public Door(Position position) {
        super('+', position);
    }

    public boolean isOpen() {
        return open;
    }

    public void open() {
        open = true;
    }

    public boolean blocksMovement() {
        return !open;
    }

}
