package bullscows;

import java.util.Objects;

public class Grader {


    private final String secretNum;


    public Grader(String secretNum) {
        this.secretNum = secretNum;
    }

    public boolean grader(String num, int numLength) {

        String[] secretNum = this.secretNum.split("");
        String[] notSoSecretNum = num.split("");

        int bulls = 0;
        int cows = 0;


        for (int i = 0; i < secretNum.length; i++) {
            for (int j = 0; j < notSoSecretNum.length; j++) {
                if (i == j) {
                    if (Objects.equals(secretNum[i], notSoSecretNum[j])) {
                        bulls++;
                    }
                } else if (Objects.equals(secretNum[i], notSoSecretNum[j])) {
                    cows++;
                }
            }
        }


        if (bulls == numLength) {
            System.out.println("Grade: " + numLength + " bulls \n" +
                    "Congratulations! You guessed the secret code.");
            return true;
        } else if (bulls != 0 && cows != 0) {
            System.out.println("Grade: " + bulls + " bull(s) and " + cows + " cow(s)");
            return false;
        } else if (bulls != 0) {
            System.out.println("Grade: " + bulls + " bull(s)");
            return false;
        } else if (cows != 0) {
            System.out.println("Grade: " + cows + " cows(s)");
            return false;
        } else {
            System.out.println("Grade: 0 bulls and 0 cows");
            return false;
        }

    }

}
