package uk.co.kellsnet;

public class Interaction {

    public static void interact(GameState state) {
        Position p = state.getPosition();
        Direction facing = state.getFacing();
        World world = state.getWorld();

        int ty = p.getY() + facing.dy();
        int tx = p.getX() + facing.dx();

        char tile = world.getTileAt(ty, tx);

        if (tile == 'C') {
            world.setTileAt(ty, tx, '.');
            state.addMessage("You opened the chest!");
        } else if (tile == '+') {
            world.setTileAt(ty, tx, '.');
            state.addMessage("You opened the door!");
        } else {
            state.addMessage("Nothing to interact with.");
        }

    }

}
