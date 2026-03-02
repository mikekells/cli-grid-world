package uk.co.kellsnet;

public class Movement {

    public static void tryMove (GameState state, int ny, int nx) {
        int y = state.getPosition().getY();
        int x = state.getPosition().getX();

        int ty = y + ny;
        int tx = x + nx;

        if (state.getWorld().getTileAt(ty, tx) != '#') {
            state.getPosition().set(ty, tx);
        }


    }

}
