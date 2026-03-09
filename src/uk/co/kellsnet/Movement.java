package uk.co.kellsnet;

public class Movement {

    public static boolean tryMove (GameState state, int ny, int nx) {
        World world = state.getWorld();
        Position p = state.getPlayer().getPosition();

        int y = p.getY();
        int x = p.getX();

        int ty = y + ny;
        int tx = x + nx;

        Entity target = state.findEntityAt(ty, tx);
        if (target != null && target.blocksMovement()) {
            return false;
        }

        if (world.isWalkable(ty, tx)) {
            p.set(ty, tx);
            return true;
        }

        return false;
    }

}
