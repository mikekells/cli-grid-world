package uk.co.kellsnet;

public class Enemy extends Entity{

    private int health = 5;

    public Enemy(Position position) {
        super('*', position);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth() {
        health++;
    }

}
