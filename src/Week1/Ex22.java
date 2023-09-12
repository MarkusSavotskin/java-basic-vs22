package Week1;

import java.util.Scanner;

public class Ex22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = "carrot";
        String enteredPassword;

        while (true) {
            System.out.print("Type the password: ");
            enteredPassword = scanner.nextLine();

            if (enteredPassword.toLowerCase().equals(password)) {
                System.out.println("Right!");
                System.out.println("\nThe secret is: bananas are nonsense");
                break;
            } else {
                System.out.println("Wrong!");
            }

        }
    }
}
