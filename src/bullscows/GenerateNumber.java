package bullscows;

import java.util.ArrayList;
import java.util.Random;

public class GenerateNumber {


    private final Random random;
    private final ArrayList<Character> secretCode;

    public GenerateNumber() {
        this.random = new Random();
        this.secretCode = new ArrayList<>();

    }

    public String generateSecretCode(int lengthOfCode, int numOfSymbols) {

        if (lengthOfCode < 37 && numOfSymbols >= lengthOfCode) {
            while (lengthOfCode > 0) {
                String NUMBERS_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyz";
                char num = NUMBERS_LETTERS.charAt(random.nextInt(numOfSymbols));
                if (!secretCode.contains(num)) {
                    this.secretCode.add(num);
                    lengthOfCode--;
                }
            }
        }


        StringBuilder secretCode = new StringBuilder();

        if (this.secretCode.size() > 0) {
            for (Character c : this.secretCode) {
                secretCode.append(c);
            }
        }

        return this.secretCode.size() > 0 ? secretCode.toString() : "none";

    }

}
