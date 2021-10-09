package bullscows;

public class CheckInput {

    public static int checkInput(String input) {

        int num = 0;

        try {

            num = Integer.parseInt(input);

        } catch (NumberFormatException e) {

            return -1;
        }

        return num;
    }

}
