package uk.co.kellsnet;

public class Movement {

    public static boolean tryMove (GameState state, int ny, int nx) {
        World world = state.getWorld();
        Position p = state.getPosition();

        int y = p.getY();
        int x = p.getX();

        int ty = y + ny;
        int tx = x + nx;

        if (world.isWalkable(ty, tx)) {
            state.getPosition().set(ty, tx);
            return true;
        }
        return false;
    }

}
