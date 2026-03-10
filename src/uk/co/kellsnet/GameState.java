package uk.co.kellsnet;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private boolean running = true;
    private Mode mode = Mode.TITLE;

    private Direction facing = Direction.RIGHT;
    private final List<String> messages = new ArrayList<>();

    private final World world;
    private final List<Entity> entities = new ArrayList<>();
    private final Player player;

    private int keys = 0;
    private int tick = 0;

    private final Pet pet;
    private final Enemy enemy;

    public GameState(World world, Position position) {
        this.world = world;
        int doorY = world.getHeight() / 2;
        int doorX1 = world.getWidth() / 2 - 2;
        int doorX2 = world.getWidth() / 2 + 2;

        entities.add(new Door(new Position(doorY,doorX1)));
        entities.add(new Door(new Position(doorY,doorX2)));

        this.player = new Player(position);
        entities.add(player);
        entities.add(new Key('K', new Position(4,8)));

        this.pet = new Pet(new Position(2, 5));
        entities.add(pet);
        addMessage("A mysterious pet arrives...");

        this.enemy = new Enemy(new Position(6, 1));
        entities.add(enemy);
        addMessage("An enemy has spawned!");
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

    public int getTick() {
        return tick;
    }

    public void advanceTick() {
        tick++;
    }

    public boolean every(int n) {
        return tick > 0 && tick % n == 0;
    }

    public void feedPet() {
        pet.increaseHunger();
    }

    public void updateSimulation() {
        if (every(3)) {
            pet.decreaseHunger();
        }

        if (pet.isDead()) {
            addMessage("Your pet has died...");
            setMode(Mode.GAME_OVER);
        }

        if(pet.getHunger() == 3) {
            addMessage("Your pet looks very hungry...");
        }

        updateEnemies();
    }

    public Mode getMode() {
        return mode;
    }

    public boolean isPlaying() {
        return mode == Mode.PLAYING;
    }

    public boolean isGameOver() {
        return mode == Mode.GAME_OVER;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Entity getEnemy() {
        return enemy;
    }

    public void updateEnemies() {
        for (Entity e : entities) {
            if (e instanceof Enemy enemy) {
                moveEnemy(enemy);
            }
        }
    }

    public void moveEnemy(Enemy enemy) {
        int currentY = enemy.getPosition().getY();
        int currentX = enemy.getPosition().getX();

        int newY = currentY;
        int newX = currentX + 1;

        if (world.inBounds(newY, newX) && world.isWalkable(newY, newX)) {
            enemy.getPosition().set(newY, newX);
        }
    }

}
