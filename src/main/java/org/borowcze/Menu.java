package org.borowcze;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Menu {

    private static final Scanner SCANNER = new Scanner(System.in);

    private static int printMenu() throws IOException {
        printLogo();
        printOptions();
        return optionInput();
    }

    protected static void mainMenu() throws IOException {
        int menuOption = Menu.printMenu();


    }

    private static void printOptions(){
        System.out.println("1. New Game");
        System.out.println("2. Continue");
        System.out.println("3. Exit");
    }

    private static void printLogo() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/banner.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    public static int optionInput() {
        Pattern pattern = Pattern.compile("[1-3]");
        String input;
        while (true) {
            input = SCANNER.nextLine();
            Matcher matcher = pattern.matcher(input);
            Boolean isInputValid = matcher.matches();
            if (isInputValid) {
                break;
            } else {
                System.out.println("Invalid input! Please try again.");
            }
        }
        switch (Integer.parseInt(input)) {
            case 1:
                System.out.println("New game");
                return 1;
            case 2:
                System.out.println("Continue");
                return 2;
            case 3:
                System.out.println("Exit");
                return 3;
        }
        return 0;
    }
}
