package uk.co.kellsnet;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        World world = new World(10, 10);
        Position position = new Position(2, 2);
        GameState state = new GameState(world, position);
        Scanner scanner = new Scanner(System.in);

        Renderer.render(state);

        String input = scanner.nextLine().trim().toUpperCase();

        char c = input.charAt(0);

        while (state.isRunning()) {
            switch (c) {
                case 'Q':
                    state.stop();
            }
        }
        System.out.println("Buh-bye.");
    }
}