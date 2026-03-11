package uk.co.kellsnet;

public class Enemy extends Entity{

    private int health = 5;

    private boolean enemyAttacks = false;

    public Enemy(Position position) {
        super('*', position);
    }

    public int getHealth() {
        return health;
    }

    public void giveHeal() {
        health++;
    }

    public void giveDamage () {
        health--;
    }



}
