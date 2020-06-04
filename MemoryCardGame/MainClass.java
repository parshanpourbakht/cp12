package MemoryCardGame;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class MainClass {

    static Point enterCoordinate() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter y ");
        int x = input.nextInt();
        System.out.println("Enter x");
        int y = input.nextInt();
        return new Point(x, y);
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        MemoryGame game = new MemoryGame();
        game.build();

        while (!game.isGameOver()) {
            System.out.println(game.getDisplay());
            System.out.println("Enter first card");
            Point first = enterCoordinate();
            System.out.println("Enter second card");
            Point second = enterCoordinate();

            boolean valid = game.nextSelection(first, second);
            if (!valid) {
                System.out.println(game.revealDisplay(first));
                Thread.sleep(1000);
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }
        }
        System.out.println("Complete!");


    }

}
