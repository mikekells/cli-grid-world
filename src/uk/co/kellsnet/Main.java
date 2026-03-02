package uk.co.kellsnet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        World world = new World(12, 24);
        Position position = new Position(2, 2);
        GameState state = new GameState(world, position);
        Renderer renderer = new Renderer();

        Scanner scanner = new Scanner(System.in);

        while (state.isRunning()) {
            renderer.render(state);

            String input = scanner.nextLine().trim().toUpperCase();
            char c = input.charAt(0);

            switch (c) {
                case 'W' -> Movement.tryMove(state, -1, 0);

                case 'A' -> Movement.tryMove(state, 0, -1);

                case 'S' -> Movement.tryMove(state, +1, 0);

                case 'D' -> Movement.tryMove(state, 0, +1);

                case 'Q' -> state.stop();
                default -> System.out.println("Use WASD or Q.");
            }
        }
        System.out.println("Buh-bye.");
    }
}