package Week2;

import java.util.Random;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Ex41 {

    public static int drawNumber() {
        Random random = new Random();
        return random.nextInt(101);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int enteredNumber;
        int randomNumber = drawNumber();
        int guesses = 0;

        while (true) {
            System.out.print("Guess a number: ");

            try {
                enteredNumber = parseInt(scanner.nextLine());
                guesses++;

                if (enteredNumber == randomNumber) {
                    System.out.println("\nCongratulations, your guess is correct!\nGuesses made: " + guesses);
                    break;
                } else {
                    if (enteredNumber < randomNumber) {
                        System.out.println("The number is greater, guesses made: " + guesses);
                    } else if (enteredNumber > randomNumber) {
                        System.out.println("The number is lesser, guesses made: " + guesses);
                    }
                }
            } catch (Exception e) {
                System.out.println("Please enter a number!");
            }
        }
    }
}
