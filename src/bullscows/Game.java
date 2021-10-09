package bullscows;

import java.util.Objects;
import java.util.Scanner;

public class Game {

    private final GenerateNumber secretNum;
    private final Scanner scanner;


    public Game() {
        this.secretNum = new GenerateNumber();
        this.scanner = new Scanner(System.in);
    }


    public void startGame() {

        String NUMBERS_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyz";
        StringBuilder numberOfStars = new StringBuilder();
        System.out.println("Please, enter the secret code's length: ");
        String length = scanner.nextLine().trim();
        int numLength = CheckInput.checkInput(length);

        if (numLength == -1) {
            System.out.println("Error: " + "\"" + length + "\" isn't a valid number.");
        } else if (numLength > 36) {
            System.out.println("Error: can't generate a secret number with a length of " + numLength +
                    "  there aren't enough unique digits.");
        } else {
            System.out.println("Input the number of possible symbols in the code: ");
            String symbols = scanner.nextLine().trim();
            int numOfSymbols = CheckInput.checkInput(symbols);

            if (numOfSymbols == -1) {
                System.out.println("Error: " + "\"" + symbols + "\" isn't a valid number.");
            } else if (numOfSymbols > 36) {
                System.out.println("Error");
            } else {
                numberOfStars.append("*".repeat(Math.max(0, numLength)));
                String secretCode = secretNum.generateSecretCode(numLength, numOfSymbols);
                if (!secretCode.equals("none")) {
                    if (numOfSymbols < 11 && !Objects.equals(secretCode, "none")) {
                        System.out.println("The secret is prepared: " + numberOfStars + " (0 - 9)");
                    } else {
                        System.out.println("The secret is prepared: " + numberOfStars + " (" + NUMBERS_LETTERS.charAt(0) + "-" + NUMBERS_LETTERS.charAt(9) + ", " + (NUMBERS_LETTERS.charAt(10) + "-" + NUMBERS_LETTERS.charAt(numOfSymbols - 1)) + ").");
                    }

                    Grader grader = new Grader(secretCode);
                    System.out.println("Okay, let's start a game!");
                    boolean exit = false;
                    int turn = 1;

                    while (!exit) {
                        System.out.println("Turn " + turn++ + ":");
                        String tryNum = scanner.next();
                        if (grader.grader(tryNum, numLength)) {
                            exit = true;
                        }
                    }

                } else {
                    System.out.println("Error: it's not possible to generate a code with a length of " + numLength + " with " + numOfSymbols + " unique symbols.");
                }
            }
        }
    }

}
