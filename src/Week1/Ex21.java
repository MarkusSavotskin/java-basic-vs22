package Week1;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Ex21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        int enteredYear;
        boolean divisibleBy4;
        boolean divisibleBy100;
        boolean divisibleBy400;

        while (true) {
            System.out.print("Enter a year: ");
            userInput = scanner.nextLine();

            if (userInput.equals("exit")) {
                break;
            } else {

                try {
                    enteredYear = parseInt(userInput);

                    divisibleBy4 = (enteredYear % 4) == 0;
                    divisibleBy100 = (enteredYear % 100) == 0;
                    divisibleBy400 = (enteredYear % 400) == 0;

                    if (divisibleBy4 && divisibleBy100) {
                        if (divisibleBy400) {
                            System.out.println(enteredYear + " is a leap year.");
                        } else {
                            System.out.println(enteredYear + " is not a leap year");
                        }
                    } else if (divisibleBy4 && !divisibleBy100) {
                        System.out.println(enteredYear + " is a leap year.");
                    } else {
                        System.out.println(enteredYear + " is not a leap year");
                    }

                } catch (Exception e) {
                    System.out.println("Please enter a valid year.");
                }
            }
        }
    }
}
