package uk.co.kellsnet;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private boolean running = true;
    private Direction facing = Direction.RIGHT;
    private final List<String> messages = new ArrayList<>();

    private final World world;
    private final Position position;

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

    public void addMessage(String message) {
        messages.add(message);
        if (messages.size() > 3) {
            messages.remove(0);
        }
    }

    public List<String> getMessages() {
        return messages;
    }
}
