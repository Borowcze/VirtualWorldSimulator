package org.borowcze;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.borowcze.World.world;

public class Game {
    private static final Scanner SCANNER = new Scanner(System.in);

    protected void newGame() {
        Pattern pattern = Pattern.compile("^[1-9][0-9]$|^(100)$");
        boolean running = true;
        String inputWidth;
        String inputHeight;

        while (running) {
            System.out.println("Enter the width of the board between 10 - 100:");
            inputWidth = SCANNER.nextLine();
            System.out.println("Enter the height of the board between 10 - 100:");
            inputHeight = SCANNER.nextLine();
            Matcher matcherWidth = pattern.matcher(inputWidth);
            Matcher matcherHeight = pattern.matcher(inputHeight);
            boolean isValidW = matcherWidth.matches();
            boolean isValidH = matcherHeight.matches();

            if(isValidH && isValidW){
                world.setWorldWidth(Integer.parseInt(inputWidth));
                world.setWorldHeight(Integer.parseInt(inputHeight));
                running = false;
            } else {
                System.out.println("\nInvalid input!");
            }
        }

        world.initializeWorld();

    }

    protected void continueGame() {

    }
}
