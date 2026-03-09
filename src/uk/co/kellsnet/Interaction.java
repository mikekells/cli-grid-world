package uk.co.kellsnet;

public class Interaction {

    public static void interact(GameState state) {
        Position p = state.getPlayer().getPosition();
        Direction facing = state.getFacing();
        World world = state.getWorld();

        int ty = p.getY() + facing.dy();
        int tx = p.getX() + facing.dx();

        if (!world.inBounds(ty, tx)) {
            state.addMessage("You can't interact outside the world.");
            return;
        }

        Entity target = state.findEntityAt(ty, tx);

        if (target instanceof Key) {
            state.removeEntity(target);
            state.addKey();
            state.addMessage("Picked up key! (Keys: " + state.getKeys() + ")");
            return;
        }

        char tile = world.getTileAt(ty, tx);

        if (tile == 'C') {
            world.setTileAt(ty, tx, '.');
            state.addMessage("You opened the chest!");
            return;
        }

        if (target instanceof Door door) {
            if (door.isOpen()) {
                state.addMessage("Door is already open");
            } else if (state.useKey()) {
                door.open();
                state.addMessage("Unlocked the door!");
            } else {
                state.addMessage("Door is locked. Need a key.");
            }
            return;
        }

        state.addMessage("Nothing here.");
    }

}
