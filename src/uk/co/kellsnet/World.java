package uk.co.kellsnet;

public class World {

    private static final char FLOOR = '.';
    private static final char WALL = '#';
    private static final char VOID = '*';

    private final int height;
    private final int width;
    private final char[][] tiles;

    public World(int height, int width) {
        this.height = height;
        this.width = width;
        this.tiles = new char[height][width];
        generateWorld();
    }

    public void generateWorld() {
        int cx = width / 2;
        int cy = height / 2;

        int r = Math.min(width, height) / 2 - 1;
        int thickness = 1;

        int outer2 = r * r;
        int innerR = r - thickness;
        int inner2 = innerR * innerR;

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                int dx = x - cx;
                int dy = y - cy;
                int d2 = dx * dx + dy * dy;

                if (d2 <= inner2) {
                    tiles[y][x] = FLOOR;        // inside room
                } else if (d2 <= outer2) {
                    tiles[y][x] = WALL;         // boundary ring
                } else {
                    tiles[y][x] = VOID;         // outside (still wall for now)
                }
            }
        }


//    public void generateWorld() {
//        // Fill the floor
//        for(int y = 0; y < height; y++) {
//            for (int x = 0; x < width; x++) {
//                tiles[y][x] = '.';
//            }
//        }

        //Border walls
        for(int x = 0; x < width; x++) {
            tiles[0][x] = '#';
            tiles[height - 1][x] = '#';
        }
        for(int y = 0; y < height; y++) {
            tiles[y][0] = '#';
            tiles[y][width - 1] = '#';
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public char getTileAt(int y, int x) {
        return tiles[y][x];
    }
}
