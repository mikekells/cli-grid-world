package uk.co.kellsnet;

import java.util.HashMap;
import java.util.Map;

public class Renderer {

    public void render(GameState state) {
        World world = state.getWorld();
        Map<String, Entity> entityAt = new HashMap<>();
        Position p = state.getPlayer().getPosition();

        for (Entity e : state.getEntities()) {
            Position ep = e.getPosition();
            entityAt.put(key(ep.getY(), ep.getX()), e);
        }

        System.out.println();
        System.out.println("=== Welcome To The Game ===");
        System.out.println();
        System.out.println("Facing: " + state.getFacing());
        System.out.println("Player Position: y:(" + p.getY() + ") x:(" + p.getX() + ")");
        System.out.println("Log:");
        for (String m : state.getMessages()) {
            System.out.println("- " + m);
        }
        System.out.println();

        for (int y = 0; y < world.getHeight(); y++) {
            for (int x = 0; x < world.getWidth(); x++) {

                if(p.getY() == y && p.getX() == x) {
                    System.out.print(state.getPlayer().getGlyph());
                } else {
                    Entity entity = entityAt.get(key(y, x));

                    if (entity != null) {
                        System.out.print(entity.getGlyph());
                    } else {
                        System.out.print(world.getTileAt(y, x));
                    }
                }
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("Keys: " + state.getKeys());
        System.out.println("Use 'WASD' or 'Q' to quit.");
        System.out.print("> ");

    }

    private String key(int y, int x) {
        return y + "," + x;
    }
}
