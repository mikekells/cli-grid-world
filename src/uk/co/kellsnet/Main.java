package uk.co.kellsnet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        World world = new World(11, 12);
        Position position = new Position(2, 2);
        GameState state = new GameState(world, position);
        Renderer renderer = new Renderer();

        Scanner scanner = new Scanner(System.in);

        while (state.isRunning()) {
            renderer.render(state);

            String input = scanner.nextLine().trim().toUpperCase();
            if(input.isEmpty()) {
                continue;
            }
            char c = input.charAt(0);

            switch (c) {
                case 'W' -> {
                    state.setFacing(Direction.UP);
                    if(!Movement.tryMove(state, -1, 0)) state.addMessage("Bump! Can't walk there.");
                }

                case 'A' -> {
                    state.setFacing(Direction.LEFT);
                    if(!Movement.tryMove(state, 0, -1)) state.addMessage("Bump! Can't walk there.");
                }

                case 'S' -> {
                    state.setFacing(Direction.DOWN);
                    if(!Movement.tryMove(state, +1, 0)) state.addMessage("Bump! Can't walk there.");
                }

                case 'D' -> {
                    state.setFacing(Direction.RIGHT);
                    if(!Movement.tryMove(state, 0, +1)) state.addMessage("Bump! Can't walk there.");
                }

                case 'E' -> {
                    Interaction.interact(state);
                }

                case 'F' -> {
                    state.feedPet();
                }

                case 'P' -> {
                    state.setMode(Mode.PLAYING);
                }

                case 'Q' -> state.stop();
                default -> System.out.println("Use WASD, E, F, or Q.");
            }

            if (c != 'Q') {
                state.advanceTick();
                state.updateSimulation();
            } else if (state.isGameOver()) {
                switch (c) {
                    case 'Q' -> state.stop();
                    default -> state.addMessage("Game over. Press Q to quit.");
                }
            }
        }
        System.out.println("Buh-bye.");
    }
}