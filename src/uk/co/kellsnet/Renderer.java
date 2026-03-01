package uk.co.kellsnet;

public class Renderer {

    public static void render(GameState state) {
        World world = state.getWorld();
        Position p = state.getPosition();

        System.out.println();
        System.out.println("=== Welcome To The Game ===");
        System.out.println("Use WASD or Q to quit.");
        System.out.println();
        System.out.print("> ");

    }

}
