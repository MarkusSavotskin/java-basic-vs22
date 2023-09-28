package Week3;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Ex53 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String enteredWord;
        String enteredNumber;
        int length;

        while (true) {
            System.out.print("Enter a word: ");
            enteredWord = scanner.nextLine();

            System.out.print("Enter the length of the first part: ");
            enteredNumber = scanner.nextLine();

            try {
                length = parseInt(enteredNumber);

                if (length > 0) {
                    if (length <= enteredWord.length()) {
                        System.out.print("Result: ");
                        System.out.println(enteredWord.substring(0, length));
                        break;

                    } else {
                        System.out.println("Entered number is larger than the entered word.");
                    }

                } else {
                    System.out.println("Entered number is too small.");
                }

            } catch (Exception e) {
                System.out.println("Please enter a number.");
            }

        }
    }
}
