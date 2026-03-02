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
            System.out.println("You opened the chest!");
        } else {
            System.out.println("Nothing to interact with.");
        }
    }

}
