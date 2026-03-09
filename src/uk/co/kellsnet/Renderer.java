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

        if (state.getMode() == Mode.TITLE) {
            System.out.println();
            System.out.println("=== Virtual Pet / World Prototype ===");
            System.out.println("Press P to play or Q to quit.");
        } else {
            System.out.println();
            System.out.println("Mode: " + state.getMode());
            System.out.println("Facing: " + state.getFacing());
            System.out.println("Player Position: y:(" + p.getY() + ") x:(" + p.getX() + ")");
            for (Entity e : state.getEntities()) {
                if (e instanceof Pet pet) {
                    System.out.println("Pet Hunger: " + pet.getHunger());
                }
            }
            System.out.println("Log:");
            for (String m : state.getMessages()) {
                System.out.println("- " + m);
            }
            System.out.println("Tick: " + state.getTick());
            System.out.println();

            for (int y = 0; y < world.getHeight(); y++) {
                for (int x = 0; x < world.getWidth(); x++) {

                    if(p.getY() == y && p.getX() == x) {
                        System.out.print(state.getPlayer().getGlyph());
                    } else {
                        Entity entity = entityAt.get(key(y, x));

                        if (entity != null) {
                            if (entity instanceof Door door && door.isOpen()) {
                                System.out.print('.');
                            } else {
                                System.out.print(entity.getGlyph());
                            }
                        } else {
                            System.out.print(world.getTileAt(y, x));
                        }
                    }
                }
                System.out.println();
            }

            System.out.println();

            if (!state.isGameOver()) {
                System.out.println("Keys: " + state.getKeys());
                System.out.println("Use 'WASD', 'E', 'F', or 'Q' to quit.");
                System.out.print("> ");
            } else {
                System.out.println();
                System.out.println("*** GAME OVER ***");
                System.out.println("Your pet has died.");
                System.out.println("Press Q to quit.");
            }
        }

    }

    private String key(int y, int x) {
        return y + "," + x;
    }
}
