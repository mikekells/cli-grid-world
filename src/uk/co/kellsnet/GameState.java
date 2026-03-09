package uk.co.kellsnet;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private boolean running = true;
    private Direction facing = Direction.RIGHT;
    private final List<String> messages = new ArrayList<>();

    private final World world;
    private final List<Entity> entities = new ArrayList<>();
    private final Player player;

    private int keys = 0;

    public GameState(World world, Position position) {
        this.world = world;

        this.player = new Player(position);
        entities.add(player);
        entities.add(new Entity('P', new Position(3, 5)));
        addMessage("A mysterious pet appears...");
        entities.add(new Key('K', new Position(4,8)));
        entities.add(new Door(new Position(5,4)));
        entities.add(new Door(new Position(5,8)));
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

    public List<Entity> getEntities() {
        return entities;
    }

    public Entity getPlayer() {
        return player;
    }

    public Entity findEntityAt(int y, int x) {
        for (Entity e : entities) {
            Position p = e.getPosition();
            if (p.getY() == y && p.getX() == x) return e;
        }
        return null;
    }

    public void removeEntity(Entity e) {
        entities.remove(e);
    }

    public int getKeys() {
        return keys;
    }

    public void addKey() {
        keys++;
    }

    public boolean useKey() {
        if (keys > 0) {
            keys--;
            return true;
        }
        return false;
    }
}
