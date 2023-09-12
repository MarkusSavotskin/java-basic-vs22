package Week1;

import java.util.Scanner;

public class Ex20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] accounts = {{"alex", "mightyducks"}, {"emily", "cat"}};
        String enteredUsername;
        String enteredPassword;
        boolean loggedIn = false;

        do {
            System.out.print("Enter your username: ");
            enteredUsername = scanner.nextLine();
            System.out.print("Enter your password: ");
            enteredPassword = scanner.nextLine();

            for (String[] account : accounts) {
                if ((enteredUsername.equals(account[0])) && (enteredPassword.equals(account[1]))) {
                    loggedIn = true;
                    System.out.println("You are now logged into the system!");
                    break;
                }
            }

            if (!loggedIn) {
                System.out.println("Your username or password was invalid!");
            }

        } while (!loggedIn);
    }
}
