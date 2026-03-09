package uk.co.kellsnet;

public class Pet extends Entity{

    private int hunger = 10;

    public Pet(Position position) {
        super('P', position);
    }

    public int getHunger() {
        return hunger;
    }

    public void decreaseHunger() {
        if (hunger > 0) {
            hunger--;
        }
    }

    public void increaseHunger() {
        if (hunger < 10) {
            hunger++;
        }
    }

    public boolean isDead() {
        return hunger <= 0;
    }


}
