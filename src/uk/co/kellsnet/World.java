package uk.co.kellsnet;

public class World {

    private static final char FLOOR = '.';
    private static final char WALL = '#';
    private static final char VOID = '*';
    private static final char DOOR = '+';

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
        // Fill the floor
        for(int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                tiles[y][x] = FLOOR;
            }
        }

        //Border walls
        for(int x = 0; x < width; x++) {
            tiles[0][x] = WALL;
            tiles[height - 1][x] = WALL;
        }
        for(int y = 0; y < height; y++) {
            tiles[y][0] = WALL;
            tiles[y][width - 1] = WALL;
        }

        // Split the world
        int wallY = height / 2;

        for (int x = 1; x < width - 1; x++) {
            tiles[wallY][x] = WALL;
        }

        tiles[wallY][width / 2 - 2] = FLOOR;
        tiles[wallY][width / 2 + 2] = FLOOR;

        // Place chest
        tiles[4][7] = 'C';
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

    public void setTileAt(int y, int x, char tile) {
        tiles[y][x] = tile;
    }

    public boolean isWalkable(int y, int x) {
        if (!inBounds(y, x)) return false;
        return tiles[y][x] != WALL;
    }

    public boolean inBounds(int y, int x) {
        return x >= 0 && x < width && y >= 0 && y < height;
    }
}
