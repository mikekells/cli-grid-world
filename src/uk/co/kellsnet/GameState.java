package uk.co.kellsnet;

public class GameState {

    private boolean running = true;
    private Direction facing = Direction.RIGHT;

    World world;
    Position position;

    public GameState(World world, Position position) {
        this.world = world;
        this.position = position;
    }

    public boolean isRunning() {
        return running;
    }

    public void stop() {
        running = false;
    }

    public World getWorld() {
        return world;
    }

    public Position getPosition() {
        return position;
    }

    public Direction getFacing() {
        return facing;
    }

    public void setFacing(Direction facing) {
        this.facing = facing;
    }
}
