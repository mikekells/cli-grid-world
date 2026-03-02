package uk.co.kellsnet;

public class World {

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
                tiles[y][x] = '.';
            }
        }

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
