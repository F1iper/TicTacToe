package TicTacToe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInfo {
    private static String name;
    private static int rounds;

    public UserInfo(String name, int rounds) {
        this.name = name;
        this.rounds = rounds;
    }


    public static void getName() {
        while (true) {
            System.out.println("Enter your name: ");
            Scanner input = new Scanner(System.in);
            name = input.nextLine();
            if (name.length() < 3) {
                System.out.println("Enter at least 3 digits");
            } else {
                System.out.println("Hi " + name);
                break;
            }
        }
    }

    public static void getRounds() {
        while (true) {
            try {
                System.out.println("Enter number of rounds: ");
                Scanner input = new Scanner(System.in);
                rounds = input.nextInt();
                if (rounds > 10 || rounds < 1)
                    System.out.println("Enter number between 1 and 10");
                else {
                    if (rounds == 1) {
                        System.out.println(rounds + " round.");
                        break;
                    } else {
                        System.out.println(rounds + " rounds.");
                    }
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Wrong input, try again.");
            }
        }
    }
}