package CodeSoft;
// Task 1 - Number Game

import java.util.Random;
import java.util.Scanner;

public class task1 {
    // 1. Generate a random number within a specified range, such as 1 to 100.
    // 2. Prompt the user to enter their guess for the generated number.
    // 3. Compare the user's guess with the generated number and provide feedback on whether the guess is correct, too high, or too low.
    // 4. Repeat steps 2 and 3 until the user guesses the correct number.
    // Additional - 
    // 5. Limit the number of attempts the user has to guess the number (n=5).
    // 6. Add the option for multiple rounds, allowing the user to play again.
    // 7. Display the user's score, which can be based on the number of attempts taken or rounds won.

    int GuessGame(int ran, int n) {
        System.out.println("X-  Guess the number b/w 1 to 100  -X");
        Scanner sc = new Scanner(System.in);
        System.out.println("You have " + n + " Guesses to predict -");
        for (int i = 0; i < n; i++) {
            System.out.print("Guess " + (i + 1) + " : ");
            int num = sc.nextInt();
            if (ran == num) {
                System.out.println("your guess is correct!");
                return 5 - i;
            } else if (num < ran) {
                if (num < ran / 2) {
                    System.out.println("Too low! Guess again");
                } else {
                    System.out.println("low! Guess again");
                }
            } else {
                if (num > ran * 2) {
                    System.out.println("Too High! Guess again");
                } else {
                    System.out.println("high! Guess again");
                }
            }
        }
        sc.close();
        return -1;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int ran = r.nextInt(1, 101), n = 5;

        task1 c = new task1();
        int score = c.GuessGame(ran, n);

        if (score == -1) {
            System.out.println("\nYour Score : " + 0);
            System.out.println("The number is : " + ran);
        } else {
            System.out.println("\nYour Score : " + score);
            System.out.println("The number is : " + ran);
        }
    }
}
