package uk.co.kellsnet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        World world = new World(6, 12);
        Position position = new Position(2, 2);
        GameState state = new GameState(world, position);
        Renderer renderer = new Renderer();

        Scanner scanner = new Scanner(System.in);

        while (state.isRunning()) {
            renderer.render(state);

            String input = scanner.nextLine().trim().toUpperCase();
            char c = input.charAt(0);

            switch (c) {
                case 'W' -> {
                    if(!Movement.tryMove(state, -1, 0)) System.out.println("Bump! Can't walk there.");
                }

                case 'A' -> {
                    if(!Movement.tryMove(state, 0, -1)) System.out.println("Bump! Can't walk there.");
                }

                case 'S' -> {
                    if(!Movement.tryMove(state, +1, 0)) System.out.println("Bump! Can't walk there.");
                }

                case 'D' -> {
                    if(!Movement.tryMove(state, 0, +1)) System.out.println("Bump! Can't walk there.");
                }

                case 'Q' -> state.stop();
                default -> System.out.println("Use WASD or Q.");
            }
        }
        System.out.println("Buh-bye.");
    }
}