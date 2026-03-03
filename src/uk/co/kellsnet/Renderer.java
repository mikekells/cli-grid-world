package uk.co.kellsnet;

import java.util.ArrayList;
import java.util.List;

public class Renderer {

    public void render(GameState state) {
        World world = state.getWorld();
        Position p = state.getPosition();

        System.out.println();
        System.out.println("=== Welcome To The Game ===");
        System.out.println();
        System.out.println("Facing: " + state.getFacing());
        System.out.println("Player Posititon: y:(" + p.getY() + ") x:(" + p.getX() + ")");
        System.out.println("Log:");
        for (String m : state.getMessages()) {
            System.out.println("- " + m);
        }
        System.out.println();

        for (int y = 0; y < world.getHeight(); y++) {
            for (int x = 0; x < world.getWidth(); x++) {
                if (x == p.getX() && y == p.getY()) {
                    System.out.print('@');
                } else {
                    System.out.print(world.getTileAt(y, x));
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Use 'WASD' or 'Q' to quit.");
        System.out.print("> ");

    }
}
