package Week4;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Ex79 {

    public static class NumberStatistics {
        private int amountOfNumbers;
        private int sum = 0;

        public void addNumber(int number) {
            amountOfNumbers++;
            sum = sum + number;
        }

        public int amountOfNumbers() {
            return this.amountOfNumbers;
        }

        public int sum() {
            return this.sum;
        }

        public double average() {
            return (double) this.sum / this.amountOfNumbers;
        }
    }

    public static void main(String[] args) {
        NumberStatistics stats = new NumberStatistics();
        NumberStatistics evens = new NumberStatistics();
        NumberStatistics odds = new NumberStatistics();
        Scanner scanner = new Scanner(System.in);

        int enteredNumber;

        System.out.println("Type numbers:");

        while (true) {

            try {
                enteredNumber = parseInt(scanner.nextLine());
                if (enteredNumber == -1) {
                    break;
                }
                stats.addNumber(enteredNumber);
                if (enteredNumber % 2 == 0) {
                    evens.addNumber(enteredNumber);
                } else {
                    odds.addNumber(enteredNumber);
                }

            } catch (Exception e) {
                System.out.println("Please enter a number.");
            }
        }

        System.out.println("sum: " + stats.sum());
        System.out.println("sum of evens: " + evens.sum());
        System.out.println("sum of odds: " + odds.sum());
    }
}
