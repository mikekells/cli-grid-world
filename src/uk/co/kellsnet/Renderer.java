package uk.co.kellsnet;

public class Renderer {

    public void render(GameState state) {
        World world = state.getWorld();
        Position p = state.getPosition();

        System.out.println();
        System.out.println("=== Welcome To The Game ===");
        System.out.println("Use WASD or Q to quit.");
        System.out.println();

        for (int y = 0; y < world.getHeight(); y++) {
            for (int x = 0; x < world.getWidth(); x++) {
                if (p.getX() == x && p.getY() == y) {
                    System.out.print('@');
                } else {
                    System.out.print(world.getTileAt(y, x));
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.print("> ");
    }

}
